package nl.windesheim.kbsm2.opc01.asrs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import org.zu.ardulink.Link;
import org.zu.ardulink.event.AnalogReadChangeEvent;
import org.zu.ardulink.event.AnalogReadChangeListener;

public class Bppimplementatie {
	private ArrayList<ArrayList<Integer>> bonnen;
    private ArrayList<ArrayList<Integer>> dozen;
    private ArrayList<Integer> acties;
    private ArrayList<Packet> packets;
    private DatabaseCon database;
	public static Link link = Link.createInstance("bbpRobot");
	int lijnsensor = 0;
	int servo = 3;
	int motor = 2;
    
    public Bppimplementatie(){
        dozen = new ArrayList();
        ArrayList<Integer> intdoos0 = new ArrayList();
        intdoos0.add(-1);
        dozen.add(intdoos0);
        ArrayList<Integer> intdoos1 = new ArrayList();
        dozen.add(intdoos1);
        ArrayList<Integer> intdoos2 = new ArrayList();
        dozen.add(intdoos2);
        database = new DatabaseCon();
        bonnen = new ArrayList();
        acties = new ArrayList();  
        
    }
    public static void delay(int tijd) {
		try {
			Thread.sleep(tijd);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    };
    
    public void connect(){
    	try {

            link.connect("COM6",115200);
            Thread.sleep(2000);
            System.out.println("verbinding gemaakt");   

				}
						
		catch(Exception e) {
			e.printStackTrace();
		}
    	
    }
    public void servoTurnLeft(){
	    int i = 0;
	    System.out.println("servo draait naar links");
    	while( i < 200){
	    	//System.out.println("start servo loop");
	    	if(i%2 == 0){
	    		//System.out.println("even");
	    		link.sendPowerPinSwitch(servo, 0);
	    		link.sendPowerPinIntensity(servo, 255);
	    		delay(10);
	    	}
	    	if(i%2 != 0){
	    		//System.out.println("Oneven");
	    		link.sendPowerPinIntensity(servo, 0);
	    		link.sendPowerPinIntensity(servo, 0);
	    		delay(10);
	    	}
	    	i++;
	    }
    }
    
    public void servoTurnRight(){
	    int i = 0;
	    System.out.println("servo draait naar rechts");
    	while( i < 100){
	    	//System.out.println("start servo loop");
	    	if(i%2 == 0){
	    		//System.out.println("even");
	    		link.sendPowerPinSwitch(servo, 1);
	    		link.sendPowerPinIntensity(servo, 255);
	    		delay(10);
	    	}
	    	if(i%2 != 0){
	    		//System.out.println("Oneven");
	    		link.sendPowerPinIntensity(servo, 1);
	    		link.sendPowerPinIntensity(servo, 0);
	    		delay(10);
	    	}
	    	i++;
	    }
    }
    
    public void reverse(ArrayList <Packet> packets) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
    	System.out.println(packets);
    	ArrayList<Packet> nieuweVolgorde = new ArrayList();
    	ArrayList<Packet> eindVolgorde = new ArrayList();
    	for(int i = 0; i < packets.size(); i++){
    		nieuweVolgorde.add(packets.get(i));
    		if(i+1 % 3 == 0 && i != 0){
    			System.out.println(i);
    			Collections.reverse(nieuweVolgorde);
    			eindVolgorde.add(nieuweVolgorde.get(0));
    			eindVolgorde.add(nieuweVolgorde.get(1));
    			eindVolgorde.add(nieuweVolgorde.get(2));
    			nieuweVolgorde.clear();
    		}
    	}
    	Collections.reverse(nieuweVolgorde);
    	for(int i = 0; i < nieuweVolgorde.size(); i++){
    		eindVolgorde.add(nieuweVolgorde.get(i));
    	}
    	this.packets = eindVolgorde;
    	System.out.println(this.packets);
    	this.start();
    }
    
    public void start() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        //this.packets = packets;
//    	link.connect();
        link.connect("COM6",115200);
        delay(2000);
        System.out.println("verbinding gemaakt"); 
    	int sum;
        int bestFit;
        int grootsteDoos;
        ArrayList<Integer> sizePackets  = new ArrayList();
        for(Packet pakket : packets){
        	ResultSet rs;
            rs = database.getSingleProduct(pakket.x, pakket.y);
        	while(rs.next()){
        	       
            	int i = rs.getInt("grootte");
            	sizePackets.add(i);
            }
        }
        for (int pakket : sizePackets) {
        	bestFit = 0;
            grootsteDoos = 0;
            
            for (int doos = 1; doos < dozen.size(); doos++) {
                sum = dozen.get(doos).stream().mapToInt(Integer::intValue).sum();
                
                if(sum > dozen.get(grootsteDoos).stream().mapToInt(Integer::intValue).sum()){
                    grootsteDoos = doos;
                }
                if (((sum + pakket) <= 10) && ((sum + pakket) > (pakket + dozen.get(bestFit).stream().mapToInt(Integer::intValue).sum()))) {
                    bestFit = doos;
                }
            }
            if(bestFit != 0){
                dozen.get(bestFit).add(pakket);
                acties.add(bestFit);
            }else{
                ArrayList<Integer> nieuwebon = new ArrayList(dozen.get(grootsteDoos));
                bonnen.add(nieuwebon);
                dozen.get(grootsteDoos).clear();
                dozen.get(grootsteDoos).add(pakket);
                acties.add(grootsteDoos);
            }
            System.out.println(dozen);
        }
        for(int doos = 1; doos < dozen.size(); doos++){
            if(dozen.get(doos) != null){
                ArrayList<Integer> nieuwebon = new ArrayList(dozen.get(doos));
                bonnen.add(nieuwebon);
            }
        }
        
		link.sendPowerPinSwitch(motor, 1);
		
		link.addAnalogReadChangeListener(new AnalogReadChangeListener() {
	        
	        @Override
	        public void stateChanged(AnalogReadChangeEvent e) {
	           lijnsensor = e.getValue();
	           
	        }
	        
	        @Override
	        public int getPinListening() {
	           return 0; // So it executes an digital input pullup(13)
	        }
	     });
        
        
        int i = 0;
        int oldI = 0;
        
        while(acties.size() > i){
        	boolean lijn = true;
        	while(lijn){
	        	if(lijnsensor > 1000){
	        		link.sendPowerPinSwitch(motor, 0);
		        	int actie = acties.get(i);
		        	if(actie == 1  && oldI == 2 || oldI == 0){
		        		servoTurnRight();
		        		oldI = 1;
		        	}
		        	if(actie == 2 && oldI == 1 || oldI == 0){
		        		servoTurnLeft();
		        		oldI = 2;
		        	}
		        	lijn = false;
		        	link.sendPowerPinSwitch(motor, 1);
		        	i++;
	        	}
        	}
        }
        link.sendPowerPinSwitch(motor, 0);
    }
    
    public ArrayList getBonnen(){
        return bonnen;
    }
    
    public ArrayList getActies(){
        return acties;
    }
}
