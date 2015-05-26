/**
Copyright 2013 Luciano Zu project Ardulink http://www.ardulink.org/

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

@author Luciano Zu
*/

package nl.windesheim.kbsm2.opc01.rxtxArdruino;

import org.zu.ardulink.Link;
import org.zu.ardulink.event.AnalogReadChangeEvent;
import org.zu.ardulink.event.AnalogReadChangeListener;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class BlinkLED extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3681838353444631779L;
	public static Link link = Link.createInstance("TEST");
	public static int motor1 = 4;
	public static int motor2 = 7;
	public static int speed1 = 5;
	public static int speed2 = 6;
	public static int power = 3;
	public static int armW = 2;
	public static int armS = 8;
	public static int lijnsensorV = 0;
	public static int lijnsensorH = 1;
	public static int x;
	public static int y;
	public static int counterY = 0;
	
    public static void delay(int tijd) {
		try {
			Thread.sleep(tijd);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    };

	public static void main(String[] args) {
		JFrame frame = new BlinkLED();
		frame.setSize(1000,600);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setTitle("test programma robot");
		frame.setVisible(true);
		
		try {

            link.connect("COM11",115200);
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
						
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
        	
            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (BlinkLED.class) {
                    switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
        					link.sendPowerPinSwitch(motor1, 0);
        					link.sendPowerPinIntensity(speed1, 255);
//                        	System.out.println(y);
                        	if(y > 1008){
                        		counterY++;
                        		System.out.println(counterY);
                        		delay(500);
                        	}
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_UP) {
        					link.sendPowerPinSwitch(motor2, 1);
        					link.sendPowerPinIntensity(speed2, 255);
                        	System.out.println(x);
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
        					link.sendPowerPinSwitch(motor2, 0);
        					link.sendPowerPinIntensity(speed2, 255);
        					link.startListenAnalogPin(lijnsensorH);
                        	System.out.println(x);
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
        					link.sendPowerPinSwitch(motor1, 1);
        					link.sendPowerPinIntensity(speed1, 200);
                        	//System.out.println(y);
                        	if(y > 1008){
                        		counterY--;
                        		System.out.println(counterY);
                        		delay(500);
                        	}
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_W) {
                        	link.sendPowerPinSwitch(armW, 1);
                        	link.sendPowerPinSwitch(armS, 0);
                        	link.sendPowerPinIntensity(power, 255);
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_S){
                        	link.sendPowerPinSwitch(armW, 0);
                        	link.sendPowerPinSwitch(armS,1);
                        	link.sendPowerPinIntensity(power, 255);
                        }
                        break;

                    case KeyEvent.KEY_RELEASED:
                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
        					link.sendPowerPinSwitch(motor1, 0);
        					link.sendPowerPinIntensity(speed1, 0);
        					System.out.println("poort 5 uit");
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_UP) {
        					link.sendPowerPinSwitch(motor2, 1);
        					link.sendPowerPinIntensity(speed2, 0);
                        	System.out.println("poort 7 uit");
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
        					link.sendPowerPinSwitch(motor2, 0);
        					link.sendPowerPinIntensity(speed2, 0);
                        	System.out.println("poort 8 uit");
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
        					link.sendPowerPinSwitch(motor1, 1);
        					link.sendPowerPinIntensity(speed1, 0);
                            System.out.println("poort 6 uit");
                        }
                        break;
                    }
                    return false;
                }
            }
        });
	
        new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}	
}
