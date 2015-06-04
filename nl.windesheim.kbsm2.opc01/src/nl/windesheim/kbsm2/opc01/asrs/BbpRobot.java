package nl.windesheim.kbsm2.opc01.asrs;

import org.zu.ardulink.Link;
import org.zu.ardulink.event.AnalogReadChangeEvent;
import org.zu.ardulink.event.AnalogReadChangeListener;

public class BbpRobot {
	public static Link link = Link.createInstance("bbpRobot");
	int lijnsensor = 0;
	int servo = 3;
	int motor = 2;
	boolean turnServo = true;

	public BbpRobot() {
		super();
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
    	while( i < 200){
	    	System.out.println("start servo loop");
	    	if(i%2 == 0){
	    		System.out.println("even");
	    		link.sendPowerPinSwitch(servo, 0);
	    		link.sendPowerPinIntensity(servo, 255);
	    		delay(10);
	    	}
	    	if(i%2 != 0){
	    		System.out.println("Oneven");
	    		link.sendPowerPinIntensity(servo, 0);
	    		link.sendPowerPinIntensity(servo, 0);
	    		delay(10);
	    	}
	    	i++;
	    }
    	turnServo = true;
    }
    
    public void servoTurnRight(){
	    int i = 0;
    	while( i < 100){
	    	System.out.println("start servo loop");
	    	if(i%2 == 0){
	    		System.out.println("even");
	    		link.sendPowerPinSwitch(servo, 1);
	    		link.sendPowerPinIntensity(servo, 255);
	    		delay(10);
	    	}
	    	if(i%2 != 0){
	    		System.out.println("Oneven");
	    		link.sendPowerPinIntensity(servo, 1);
	    		link.sendPowerPinIntensity(servo, 0);
	    		delay(10);
	    	}
	    	i++;
	    }
    	turnServo = false;
    }
	
	public void startBbp(int aantalPakketten){
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
		boolean test = true;
		int i = 0;
	    while(test){
	    	//System.out.println(lijnsensor);
			if(lijnsensor > 1000){
				link.sendPowerPinSwitch(motor, 0);
				delay(1000);
				if(turnServo){
					servoTurnRight();
				}
				else {
					servoTurnLeft();
				}
				i++;
				if(i == aantalPakketten){
					test = false;
				}
				
			}
			link.sendPowerPinSwitch(motor, 0);
			
	    }
		

	}

}
