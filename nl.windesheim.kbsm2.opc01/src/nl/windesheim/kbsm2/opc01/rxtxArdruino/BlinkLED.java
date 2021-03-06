/**
wsCopyright 2013 Luciano Zu project Ardulink http://www.ardulink.org/

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
import org.zu.ardulink.event.*;

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
	public static int y = 1;
	public static int counterY = 0;
	public static int counterX = 0;
	
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
        link.addDigitalReadChangeListener(new DigitalReadChangeListener() {
            
            @Override
            public void stateChanged(DigitalReadChangeEvent e) {
               y = e.getValue();
               
            }
            
            @Override
            public int getPinListening() {
               return 13; // So it executes an digital read pullup(13)
            }
         });
        
        link.addDigitalReadChangeListener(new DigitalReadChangeListener() {
            
            @Override
            public void stateChanged(DigitalReadChangeEvent e) {
               x = e.getValue();
               
            }
            
            @Override
            public int getPinListening() {
               return 12; // So it executes an analogRead(12)
            }
         });
						
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
        	
            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (BlinkLED.class) {
                    switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        if (ke.getKeyCode() == KeyEvent.VK_UP) {
//        					boolean test = true;
//        					boolean test2 = true;
        					link.sendPowerPinSwitch(motor1, 0);
        					link.sendPowerPinIntensity(speed1, 255);
//                        	while(test){
//                        	System.out.println(y);
//                        	delay(200);
//                        	if(y == 0){
//                        		counterY++;
//                        		System.out.println(y);
//                        		delay(1000);
//                        		}	
////                        		if(counterY == 5){
////                        			test=false;
////                        			link.sendPowerPinSwitch(motor1, 1);
////                					link.sendPowerPinIntensity(speed1, 150);	
////                        			while(test2){
////                                    	if(y == 0){
////                                    		counterY--;
////                                    		System.out.println(counterY);
////                                    		delay(1000);
////                                    		}
////                    					if(counterY == 0){
////                        					
////                        					test2 = false;
////                        				}
////                        			}       	
////        						}
//                        	}
//                        	link.sendPowerPinSwitch(motor1, 1);
//        					link.sendPowerPinIntensity(speed1, 0);
                        	

                        	//System.out.println(y);

                        }
                        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
        					link.sendPowerPinSwitch(motor2, 1);
        					link.sendPowerPinIntensity(speed2, 255);
        					if(counterX != 0){
        						vol: if(x == 0){
        							for(int i = 0; i <= 8; i++){
        								delay(5);
        								if(x != 0){
        									break vol;
        								}
        							}
        							counterX--;
        							System.out.println(counterX);
        							delay(600);
        						}
        					} else{
        						link.sendPowerPinSwitch(motor2, 0);
            					link.sendPowerPinIntensity(speed2, 0);
        					}
                        	//System.out.println(x);
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
        					link.sendPowerPinSwitch(motor2, 0);
        					link.sendPowerPinIntensity(speed2, 255);
        					if(counterX != 6){
        						vol: if(x == 0){
        							for(int i = 0; i <= 8; i++){
        								delay(5);
        								if(x != 0){
        									break vol;
        								}
        							}
        							counterX++;
        							System.out.println(counterX);
        							delay(600);
        						}
        					}else{
        						link.sendPowerPinSwitch(motor2, 0);
            					link.sendPowerPinIntensity(speed2, 0);
        					}
                        	//System.out.println(x);
                        	
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
        					link.sendPowerPinSwitch(motor1, 1);
        					link.sendPowerPinIntensity(speed1, 150);
                        	System.out.println(y);
                        	if(y == 0){
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
                        if(ke.getKeyCode()== KeyEvent.VK_F){
                        	System.out.println("waarde lijnsensor:"+x);
                        	System.out.println("waarde pullup:"+y);
                        	delay(100);
                        }
                        if(ke.getKeyCode() == KeyEvent.VK_P){
                        	System.out.println("producten afleveren");
                        	link.sendPowerPinSwitch(motor1, 1);
                    		link.sendPowerPinIntensity(speed1, 255);
                    		delay(500);
                    		link.sendPowerPinSwitch(motor1, 1);
                    		link.sendPowerPinIntensity(speed1, 0);
                    		delay(100);
                        	//arm naar voren
                        	link.sendPowerPinSwitch(armW, 0);
                        	link.sendPowerPinSwitch(armS, 1);
                        	link.sendPowerPinIntensity(power, 255);
                        	delay(200);
//                        	//omlaag
                    		link.sendPowerPinSwitch(motor1, 1);
                    		link.sendPowerPinIntensity(speed1, 80);
                    		delay(1400);
                    		link.sendPowerPinSwitch(motor1, 1);
                    		link.sendPowerPinIntensity(speed1, 0);
//                        	//arm naar achteren
//                        	link.sendPowerPinSwitch(armW, 1);
//                        	link.sendPowerPinSwitch(armS, 0);
//                        	link.sendPowerPinIntensity(power, 255);
                        }
                        break;
                
            
                    case KeyEvent.KEY_RELEASED:
                        if (ke.getKeyCode() == KeyEvent.VK_UP) {
        					link.sendPowerPinSwitch(motor1, 0);
        					link.sendPowerPinIntensity(speed1, 0);
        					System.out.println("poort 5 uit");
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
        					link.sendPowerPinSwitch(motor2, 1);
        					link.sendPowerPinIntensity(speed2, 0);
                        	System.out.println("poort 7 uit");
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
        					link.sendPowerPinSwitch(motor2, 0);
        					link.sendPowerPinIntensity(speed2, 0);
                        	System.out.println("poort 8 uit");
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
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
