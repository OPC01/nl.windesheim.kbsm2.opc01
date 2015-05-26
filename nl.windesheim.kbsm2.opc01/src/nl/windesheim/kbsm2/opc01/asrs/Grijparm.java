package nl.windesheim.kbsm2.opc01.asrs;

import java.sql.SQLException;
import java.util.ArrayList;

import org.zu.ardulink.Link;
import org.zu.ardulink.event.AnalogReadChangeEvent;
import org.zu.ardulink.event.AnalogReadChangeListener;

public class Grijparm {
	int locationX,locationY,y = 0,x = 0;
	public static int sensorX,sensorY;
	public static Link link = Link.createInstance("TEST");
	public static int power = 3;
	public static int armW = 2;
	public static int armS = 8;
	public static int motor1 = 4;
	public static int motor2 = 7;
	public static int speed1 = 5;
	public static int speed2 = 6;
	
    public Grijparm(){
    	
    }
    
    public static void delay(int tijd) {
		try {
			Thread.sleep(tijd);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    };
        
    public void moveTo(int x, int y){
		connect();
		
	    link.addAnalogReadChangeListener(new AnalogReadChangeListener() {
	        
	        @Override
	        public void stateChanged(AnalogReadChangeEvent e) {
	           sensorY = e.getValue();
	           
	        }
	        
	        @Override
	        public int getPinListening() {
	           return 0; // So it executes an analogRead(0)
	        }
	     });
	    
	    link.addAnalogReadChangeListener(new AnalogReadChangeListener() {
	        
	        @Override
	        public void stateChanged(AnalogReadChangeEvent e) {
	           sensorX = e.getValue();
	           
	        }
	        
	        @Override
	        public int getPinListening() {
	           return 1; // So it executes an analogRead(1)
	        }
	     });
		
		int locationX = this.locationX;
		int locationY = this.locationY;
        int futureLocationX = x;
        int futureLocationY = y;
        x = locationX-x;
        y = y-locationY;
        if(x > 0){
        	//loop int i ++ tot gelijk aan x dan motor uit.
        	//omhoog
        	int i = 0;
        	while(x != i){
	        	link.sendPowerPinSwitch(motor1, 0);
	        	link.sendPowerPinIntensity(speed1, 255);
	        	if(sensorX > 1004){
	        		i++;
	        		delay(500);
	        	}
        	}
        	link.sendPowerPinSwitch(motor1, 0);
        	link.sendPowerPinIntensity(speed1, 0);
        	delay(300);
        }
        if(y > 0){
        	//naar rechts
        	int i = 0;
        	while(x != i){
	        	link.sendPowerPinSwitch(motor2, 0);
	        	link.sendPowerPinIntensity(speed1, 255);
	        	if(sensorY > 1004){
	        		i++;
	        		delay(500);
	        	}
        	}
        	link.sendPowerPinSwitch(motor2, 0);
        	link.sendPowerPinIntensity(speed1, 0);
        	delay(300);
        }
        if(x < 0){
        	//omlaag
        	int i = 0;
        	while(x != i){
	        	link.sendPowerPinSwitch(motor1, 0);
	        	link.sendPowerPinIntensity(speed1, 255);
	        	if(sensorX > 1004){
	        		i--;
	        		delay(500);
	        	}
        	}
        	link.sendPowerPinSwitch(motor1, 0);
        	link.sendPowerPinIntensity(speed1, 0);
        	delay(300);
        	
        }
        if(y < 0){
        	//naar links
        	int i = 0;
        	while(x != i){
	        	link.sendPowerPinSwitch(motor2, 1);
	        	link.sendPowerPinIntensity(speed1, 255);
	        	if(sensorY > 1004){
	        		i--;
	        		delay(500);
	        	}
        	}
        	link.sendPowerPinSwitch(motor2, 1);
        	link.sendPowerPinIntensity(speed1, 0);
        	delay(300);
        }
        


//		delay(500);
//		link.sendPowerPinSwitch(motor1, 0);
//		link.sendPowerPinIntensity(speed1, 0);
//		//omlaag
//		link.sendPowerPinSwitch(motor1, 1);
//		link.sendPowerPinIntensity(speed1, 200);
//		//naar rechts bewegen.
//		link.sendPowerPinSwitch(motor2, 0);
//		link.sendPowerPinIntensity(speed2, 255);
//		//naar links bewegen.
//		link.sendPowerPinSwitch(motor2, 1);
//		link.sendPowerPinIntensity(speed2, 255);
                       
    }
    
    public void connect(){
    	try {

            link.connect("COM5",115200);
            Thread.sleep(2000);
            System.out.println("verbinding gemaakt");   

				}
						
		catch(Exception e) {
			e.printStackTrace();
		}
    	
    	link.addAnalogReadChangeListener(new AnalogReadChangeListener() {
            
            @Override
            public void stateChanged(AnalogReadChangeEvent e) {
               y = e.getValue();
               
            }
            
            @Override
            public int getPinListening() {
               return 0; // So it executes an analogRead(0)
            }
         });
    	
        link.addAnalogReadChangeListener(new AnalogReadChangeListener() {
            
            @Override
            public void stateChanged(AnalogReadChangeEvent e) {
               x = e.getValue();
               
            }
            
            @Override
            public int getPinListening() {
               return 1; // So it executes an analogRead(1)
            }
         });
    }
    
    public int getSensorY(){   	
    	return y;
    }
    
    public int getSensorX(){
    	return x;
    }
    public void dropOfProducts(){
    	moveTo(0,0);
    	//arm naar voren
    	link.sendPowerPinSwitch(armW, 0);
    	link.sendPowerPinSwitch(armS, 1);
    	link.sendPowerPinIntensity(power, 255);
    	//omlaag
		link.sendPowerPinSwitch(motor1, 1);
		link.sendPowerPinIntensity(speed1, 255);
		delay(500);
		link.sendPowerPinSwitch(motor1, 1);
		link.sendPowerPinIntensity(speed1, 0);
    	//arm naar achteren
    	link.sendPowerPinSwitch(armW, 1);
    	link.sendPowerPinSwitch(armS, 0);
    	link.sendPowerPinIntensity(power, 255);
    }
    
    public void pickUpProduct(){
    	//arm naar voren
    	link.sendPowerPinSwitch(armW, 0);
    	link.sendPowerPinSwitch(armS, 1);
    	link.sendPowerPinIntensity(power, 255);
    	//omhoog
		link.sendPowerPinSwitch(motor1, 0);
		link.sendPowerPinIntensity(speed1, 255);
		delay(500);
		link.sendPowerPinSwitch(motor1, 0);
		link.sendPowerPinIntensity(speed1, 0);
    	//arm naar achteren
    	link.sendPowerPinSwitch(armW, 1);
    	link.sendPowerPinSwitch(armS, 0);
    	link.sendPowerPinIntensity(power, 255);
    }

	public int getLocationX() {
		return locationX;
	}

	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}

	public int getLocationY() {
		return locationY;
	}

	public void setLocationY(int locationY) {
		this.locationY = locationY;
	}
	
	public void startOrder(int orderNr) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Order order = new Order(orderNr);
		
		ArrayList<Packet> producten = order.getProducten();
        TSPNearestNeighbourASRS algoritme = new TSPNearestNeighbourASRS();
        ArrayList<Packet> volgorde = algoritme.tsp(producten);
		int aantalPakketten = 0;
        
        int i = 0;
        while(volgorde.size() > i){
        	Packet p = volgorde.get(i);
        	int x = p.x;
        	int y = p.y;
        	moveTo(x,y);
        	pickUpProduct();
        	aantalPakketten++;
        	if(aantalPakketten == 3){
	        	moveTo(0,0);
	        	dropOfProducts();
	        	aantalPakketten = 0;
        	}	
        	i++;
        	setLocationX(x);
        	setLocationY(y);
        }

	}
}
