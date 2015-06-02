package nl.windesheim.kbsm2.opc01.asrs;

import java.sql.SQLException;
import java.util.ArrayList;

import org.zu.ardulink.Link;
import org.zu.ardulink.event.AnalogReadChangeEvent;
import org.zu.ardulink.event.AnalogReadChangeListener;

public class Grijparm {
	int locationX,locationY = 2,y = 0,x = 0;
	public static int sensorX,sensorY;
	public static Link link = Link.createInstance("ASRS");
	public static int power = 3;
	public static int armW = 2;
	public static int armS = 8;
	public static int motor1 = 4;
	public static int motor2 = 7;
	public static int speed1 = 5;
	public static int speed2 = 6;
	BbpRobot bbpRobot = new BbpRobot();
	
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
		
		
	    link.addAnalogReadChangeListener(new AnalogReadChangeListener() {
	        
	        @Override
	        public void stateChanged(AnalogReadChangeEvent e) {
	           sensorX = e.getValue();
	           
	        }
	        
	        @Override
	        public int getPinListening() {
	           return 0; // So it executes an analogRead(0)
	        }
	     });
	    
	    link.addAnalogReadChangeListener(new AnalogReadChangeListener() {
	        
	        @Override
	        public void stateChanged(AnalogReadChangeEvent e) {
	           sensorY = e.getValue();
	           
	        }
	        
	        @Override
	        public int getPinListening() {
	           return 13; // So it executes an digital input pullup(13)
	        }
	     });
		
		int locationX = this.locationX;
		int locationY = this.locationY;
        int futureLocationX = x;
        int futureLocationY = y;
        System.out.println(locationX);
        System.out.println("move to function wordt gestart.");
        
        x = x-locationX;
        y = y-locationY;
        System.out.println(x);
        System.out.println(y);
        if(y > 0){// verticale as
        	//loop int i ++ tot gelijk aan x dan motor uit.
        	//omhoog
        	int i = 0;
        	while(y != i){// horizontaal
	        	link.sendPowerPinSwitch(motor2, 0);
	        	link.sendPowerPinIntensity(speed2, 255);
	        	if(sensorY == 0){
	        		i++;
	        		delay(1000);
	        	}
        	}
        	if(y == i){
        	link.sendPowerPinSwitch(motor2, 0);
        	link.sendPowerPinIntensity(speed2, 0);
        	}
        	delay(300);
        }
        if(x > 0){
        	//naar rechts
        	int i = 0;
        	while(x != i){
	        	link.sendPowerPinSwitch(motor1, 0);
	        	link.sendPowerPinIntensity(speed1, 255);
	        	if(sensorX == 0){
	        		System.out.println("omhoogLijnsensor");
	        		i++;
	        		delay(1000);
	        	}
        	}
        	if(x == i){
        		System.out.println("rem");
        	link.sendPowerPinSwitch(motor1, 0);
        	link.sendPowerPinIntensity(speed1, 0);
        	}
        	delay(300);
        }
        if(y < 0){
        	//omlaag
        	int i = 0;
        	while(y != i){
	        	link.sendPowerPinSwitch(motor2, 1);
	        	link.sendPowerPinIntensity(speed2, 255);
	        	if(sensorY == 0){
	        		i--;
	        		delay(1000);
	        	}
        	}
        	if(x == 0){
        	link.sendPowerPinSwitch(motor2, 1);
        	link.sendPowerPinIntensity(speed2, 0);
        	}
        	delay(300);
        }          
        	
        	
        
        if(y < 0){
        	//naar links
        	int i = 0;
        	while(x != i){
	        	link.sendPowerPinSwitch(motor1, 1);
	        	link.sendPowerPinIntensity(speed1, 255);
	        	if(sensorX == 1){
	        		System.out.println("omlaagLijnsensor");
	        		i--;
	        		delay(1000);
	        	}
        	}
        	if(x == i){
	        	link.sendPowerPinIntensity(speed1, 0);
        	}
        	if(y == i){
	        	link.sendPowerPinIntensity(speed2, 0);
        	}
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
    public void dropOfProducts(){
    	System.out.println("producten afleveren");
    	moveTo(0, 2);
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
    	System.out.println("product oppakken");
    	//arm naar voren
    	link.sendPowerPinSwitch(armW, 0);
    	link.sendPowerPinSwitch(armS, 1);
    	link.sendPowerPinIntensity(power, 255);
    	delay(500);
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
		System.out.println("Order gestart");
		ArrayList<Packet> producten = order.getProducten();
        TSPNearestNeighbourASRS algoritme = new TSPNearestNeighbourASRS();
        ArrayList<Packet> volgorde = algoritme.tsp(producten);
		int aantalPakketten = 0;
        
    	link.sendPowerPinSwitch(motor2, 0);
    	link.sendPowerPinIntensity(speed2, 255);
    	delay(500);
    	link.sendPowerPinSwitch(motor2, 0);
    	link.sendPowerPinIntensity(speed2, 0);
    	
        int i = 0;
        while(volgorde.size() > i){
        	Packet p = volgorde.get(i);
        	System.out.println("pakketten geladen");
        	int x = p.x;
        	int y = p.y;
        	moveTo(x,y);
        	pickUpProduct();
        	System.out.println("pick up");
        	aantalPakketten++;
        	if(aantalPakketten == 3){
	        	dropOfProducts();
	        	bbpRobot.startBbp(aantalPakketten);
	        	setLocationX(x);
	        	setLocationY(y);
	        	System.out.println(x + " heeft 3 pakketten afgelevert");
	        	System.out.println(y + "heeft 3 pakketten afgelevert");
	        	aantalPakketten = 0;
        	}	
        	i++;
        	setLocationX(x);
        	setLocationY(y);
        }
        System.out.println("alles opgehaald");
        dropOfProducts();
        bbpRobot.startBbp(aantalPakketten);

	}
}
