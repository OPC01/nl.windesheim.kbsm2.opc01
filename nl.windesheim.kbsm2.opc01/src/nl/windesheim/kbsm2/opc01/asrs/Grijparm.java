package nl.windesheim.kbsm2.opc01.asrs;

import java.sql.SQLException;
import java.util.ArrayList;

import org.zu.ardulink.event.*;
import org.zu.ardulink.Link;
//import org.zu.ardulink.event.AnalogReadChangeEvent;
//import org.zu.ardulink.event.AnalogReadChangeListener;

public class Grijparm {
	int locationX,locationY = 2,y = 0,x = 0;
	int nextYlocation = 0;
	public static int sensorX,sensorY;
	public static Link link = Link.createInstance("ASRS");
	public static int power = 3;
	public static int armW = 2;
	public static int armS = 8;
	public static int motor1 = 4;
	public static int motor2 = 7;
	public static int speed1 = 5;
	public static int speed2 = 6;
	int aantalPakketten = 0;
	Bppimplementatie bbp = new Bppimplementatie();
	
	
    public Grijparm(){
    	connect();
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
		
	    link.addDigitalReadChangeListener(new DigitalReadChangeListener() {
	        
	        @Override
	        public void stateChanged(DigitalReadChangeEvent e) {
	           sensorX = e.getValue();
	           
	        }
	        
	        @Override
	        public int getPinListening() {
	           return 11; // So it executes an analogRead(0)
	        }
	     });
	    
	    link.addDigitalReadChangeListener(new DigitalReadChangeListener() {
	        
	        @Override
	        public void stateChanged(DigitalReadChangeEvent e) {
	           sensorY = e.getValue();
	           
	        }
	        
	        @Override
	        public int getPinListening() {
	           return 13; // So it executes an digital input pullup(13)
	        }
	     });
		
		int locationX = this.locationX;
		int locationY = this.locationY;
//        System.out.println(locationX);
        System.out.println("move to function wordt gestart.");
        
        x = x-locationX;
        y = y-locationY;
        
//        int FiveChecker = y+locationY;
//        if(FiveChecker == 5){
//        	link.sendPowerPinSwitch(motor1, 0);
//        	link.sendPowerPinIntensity(speed1, 255);
//        	delay(500);
//        	link.sendPowerPinIntensity(speed1, 0);
//        }
        System.out.println("x in moveTo function ="+x);
        System.out.println("y in moveTo function ="+y);
        if(y > 0){// verticale as
        	//loop int i ++ tot gelijk aan x dan motor uit.
        	//omhoog
            System.out.println("y as moet"+y+" stappen omhoog");
        	link.sendPowerPinSwitch(motor1, 0);
        	link.sendPowerPinIntensity(speed1, 255);
        	delay(200);
        	link.sendPowerPinIntensity(speed1, 0);
        	int i = 0;
        	link.sendPowerPinSwitch(motor1, 0);
        	link.sendPowerPinIntensity(speed1, 255);
//        	boolean stop = true;
        	if(y != 0){
        		delay(500);
        	}
        	yVerticaalUp: while(y != i){// verticaal
//        		if(stop){
//        			delay(600);
//        			stop = false;
//        		}
        		if(sensorY == 0){
	        		i++;
	        		System.out.println(y + "omhoog");
//	        		System.out.println("omhoog" + i);
	        		
	        		if(y == i){
	        			break yVerticaalUp;
	        		}
	        		delay(1000);
	        	}
	        	delay(1);
        	}
        	link.sendPowerPinSwitch(motor1, 0);
        	link.sendPowerPinIntensity(speed1, 0);
        	delay(300);//remmen zodat er pakketjes kunnen opgepakt
        }
        if(x > 0){
        	//naar rechts
        	link.sendPowerPinSwitch(motor2, 0);
        	link.sendPowerPinIntensity(speed2, 255);
        	delay(1000);
        	link.sendPowerPinIntensity(speed2, 0);
        	int i = 0;
        	link.sendPowerPinSwitch(motor2, 0);
        	link.sendPowerPinIntensity(speed2, 255);
        	xHorizontaalRight: while(x != i){//horizontaal
	        	if(sensorX == 0){
	        		i++;
//	        		System.out.println(x + "naar rechts");
//	        		System.out.println("rechts" + i);
	        		if(x == i){
	        			break xHorizontaalRight;
	        		}
	        		delay(1000);
	        	}
	        	delay(1);
        	}
        	link.sendPowerPinSwitch(motor2, 0);
        	link.sendPowerPinIntensity(speed2, 0);
        	delay(300);
        }
        if(y < 0){
        	//omlaag
            System.out.println("y as moet"+y+" stappen omlaag");
        	link.sendPowerPinSwitch(motor1, 1);
        	link.sendPowerPinIntensity(speed1, 255);
        	delay(300);
        	link.sendPowerPinIntensity(speed1, 0);
        	int i = 0;
        	link.sendPowerPinSwitch(motor1, 1);
        	link.sendPowerPinIntensity(speed1, 255);
        	yVerticaalDown: while(y != i){//verticaal
	        	if(sensorY == 0){
	        		i--;
//	        		System.out.println(y + " omlaag");
//	        		System.out.println("omlaag" + i);
	        		if(y == i){
	        			break yVerticaalDown;
	        		}
	        		delay(400);
	        	}
	        	delay(1);
        	}
        	link.sendPowerPinSwitch(motor1, 1);
        	link.sendPowerPinIntensity(speed1, 0);
        	delay(300);//remmen zodat er pakketjes kunnen opgepakt
        }          
        	
        	
        
        if(x < 0){
        	//naar links
        	link.sendPowerPinSwitch(motor2, 1);
        	link.sendPowerPinIntensity(speed2, 255);
        	delay(500);
        	link.sendPowerPinIntensity(speed2, 0);
        	int i = 0;
        	link.sendPowerPinSwitch(motor2,1);
        	link.sendPowerPinIntensity(speed2, 255);
        	xHorizontaalLeft: while(x != i){//horizontaal
	        	if(sensorX == 0){
//	        		System.out.println(x + "naar links");
//	        		System.out.println("links" + i);
	        		i--;
	        		if(x == i){
	        			break xHorizontaalLeft;
	        		}
	        		delay(1000);
	        	}
	        	delay(1);
        	}
        	link.sendPowerPinSwitch(motor2, 0);
        	link.sendPowerPinIntensity(speed2, 0);
        	delay(300);
        }
    }
    
    public void connect(){
    	try {

            link.connect("COM11",115200);
            Thread.sleep(2000);
            System.out.println("verbinding gemaakt");   

				}
						
		catch(Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    public int getSensorY(){   	
    	return y;
    }
    
    public int getSensorX(){
    	return x;
    }
    public void dropOfProducts(ArrayList<Packet> packets) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
    	//bbpRobot.startBbp(aantalPakketten);
    	System.out.println("producten afleveren");
    	//naar links bewegen
    	link.sendPowerPinSwitch(motor2, 1);
    	link.sendPowerPinIntensity(speed2, 255);
    	delay(250);
    	//motor links uit
    	link.sendPowerPinIntensity(speed2, 0);
    	delay(50);
    	//naar beneden
    	link.sendPowerPinSwitch(motor1, 1);
		link.sendPowerPinIntensity(speed1, 255);
		delay(400);
		link.sendPowerPinIntensity(speed1, 0);
		delay(100);
    	//arm naar voren
    	link.sendPowerPinSwitch(armW, 0);
    	link.sendPowerPinSwitch(armS, 1);
    	link.sendPowerPinIntensity(power, 255);
    	delay(200);
//    	//omlaag
		link.sendPowerPinSwitch(motor1, 1);
		link.sendPowerPinIntensity(speed1, 80);
		delay(1400);
		link.sendPowerPinSwitch(motor1, 1);
		link.sendPowerPinIntensity(speed1, 0);
//    	//arm naar achteren
//		bbpRobot.startBbp(aantalPakketten);
		bbp.reverse(packets);
		delay(1);
    	link.sendPowerPinSwitch(armW, 1);
    	link.sendPowerPinSwitch(armS, 0);
    	link.sendPowerPinIntensity(power, 255);
    	setLocationX(0);
    	setLocationY(1);
    	link.sendPowerPinSwitch(motor1, 0);
		link.sendPowerPinIntensity(speed1, 255);
		delay(300);
		link.sendPowerPinIntensity(speed1, 0);
    	moveTo(0, 2);
    	setLocationX(0);
    	setLocationY(2);
    	link.sendPowerPinSwitch(motor1, 0);
		link.sendPowerPinIntensity(speed1, 255);
		delay(250);
		link.sendPowerPinIntensity(speed1, 0);

    	aantalPakketten = 0;
    	
    }
    
    public void pickUpProduct(){
    	System.out.println("product oppakken");
//    	//heel iets naar beneden gaan.
//    	link.sendPowerPinSwitch(motor1, 1);
//		link.sendPowerPinIntensity(speed1, 255);
//		delay(100);
//		link.sendPowerPinIntensity(speed1, 0);
    	//arm naar voren
    	link.sendPowerPinSwitch(armW, 0);
    	link.sendPowerPinSwitch(armS, 1);
    	link.sendPowerPinIntensity(power, 255);
    	delay(500);
    	//omhoog
		link.sendPowerPinSwitch(motor1, 0);
		link.sendPowerPinIntensity(speed1, 255);
		delay(1000);
		link.sendPowerPinSwitch(motor1, 0);
		link.sendPowerPinIntensity(speed1, 0);
    	//arm naar achteren
    	link.sendPowerPinSwitch(armW, 1);
    	link.sendPowerPinSwitch(armS, 0);
    	link.sendPowerPinIntensity(power, 255);
    	delay(500);
    	link.sendPowerPinSwitch(motor1, 1);
		link.sendPowerPinIntensity(speed1, 255);
		delay(270);
		link.sendPowerPinSwitch(motor1, 0);
		link.sendPowerPinIntensity(speed1, 0);
		//iets piets naarbeneden
		delay(300);
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
		//order ini
		Order order = new Order(orderNr);
		System.out.println("Order gestart");
		//producten ophalen
		ArrayList<Packet> producten = order.getProducten();
        producten.add(0,new Packet(0,2));
        TSPNearestNeighbourASRS algoritme = new TSPNearestNeighbourASRS();

        ArrayList<Packet> volgorde = algoritme.tsp(producten);
        //kleine stap naar rechts
    	link.sendPowerPinSwitch(motor2, 0);
    	link.sendPowerPinIntensity(speed2, 255);
    	delay(500);
    	link.sendPowerPinSwitch(motor2, 0);
    	link.sendPowerPinIntensity(speed2, 0);
    	//i ini
        int i = 0;
        System.out.println("pakketten geladen");
        //start pakketten ophalen
        ophaalPakket: while(volgorde.size() > i){
        	Packet p = volgorde.get(i);
        	int x = p.x;
        	int y = p.y;
        	System.out.println("");
        	moveTo(x,y);
        	pickUpProduct();
        	//System.out.println("pick up");
        	aantalPakketten++;
        	if(aantalPakketten == 3){
        		setLocationX(x);
	        	setLocationY(y);
	        	System.out.println("x is "+x);
	        	System.out.println("y is "+y);
	        	moveTo(0,2);
	        	dropOfProducts(volgorde);
	        	x = 0;
	        	y = 2;
	        	setLocationX(x);
	        	setLocationY(y);
	        	System.out.println("y is naar drop of "+y);
	        	System.out.println("x is naar drop of "+x);
	        	if(volgorde.size() > i+1){
	        	}
	        	else{
	        		System.out.println("break");
		        	System.out.println("x is else/break statement "+x);
		        	System.out.println("y is else/break statement "+y);
	        		break ophaalPakket;
	        	}
	        	i++;
        	}else{	
	        	i++;
	        	setLocationX(x);
	        	setLocationY(y);
	        	if(volgorde.size() > i){
	        		Packet next = volgorde.get(i);
	        		nextYlocation = next.y;
	        	}
	        	
	        	if(nextYlocation == 5){
	            	link.sendPowerPinSwitch(motor1, 0);
	        		link.sendPowerPinIntensity(speed1, 255);
	        		delay(400);
	        		link.sendPowerPinIntensity(speed1, 0);
	        	}
	        	System.out.println("x is else statement "+x);
	        	System.out.println("y is else statement "+y);
        	}
//        	oldYlocation = y;
        }
        System.out.println("alles opgehaald");

    	if(aantalPakketten >= 1){
	    	moveTo(0,2);//dit is de begin positie
	        setLocationX(0);
	    	setLocationY(2);
	    	dropOfProducts(volgorde);
    	}
    		
	}
}
