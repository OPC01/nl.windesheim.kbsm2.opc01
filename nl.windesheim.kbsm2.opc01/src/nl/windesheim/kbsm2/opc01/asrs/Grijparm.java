package nl.windesheim.kbsm2.opc01.asrs;

import java.util.ArrayList;
import javax.swing.JFrame;

import org.zu.ardulink.Link;
import org.zu.ardulink.event.AnalogReadChangeEvent;
import org.zu.ardulink.event.AnalogReadChangeListener;

public class Grijparm {
	int locationX,locationY,y = 0,x = 0;
	public static int sensorX,sensorY;
	public static Link link = Link.createInstance("TEST");
	
    public Grijparm(){
    	
    }
    
    
    
    public void moveTo(int x, int y){
		connect();
		int locationX = this.locationX;
		int locationY = this.locationY;
        
        x = x-locationX;
        y = y-locationY;
               
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
    
    public void pickUpProduct(){
    	
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
	
	public void startOrder(int orderNr){
		// haal artikelid's op
		// haal locatie artikelen op
		// verwerk in algoritme
            TSPNearestNeighbourASRS algoritme = new TSPNearestNeighbourASRS();
            ArrayList<Packet> volgorde = algoritme.tsp(null /*voeg arrayList Packets toe */);
		// get locatie
		// haal pakket 1 op
		// set locatie
		// haal volgende
	}
}
