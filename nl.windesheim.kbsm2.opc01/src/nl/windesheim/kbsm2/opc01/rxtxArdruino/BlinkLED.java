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

import java.util.List;
import java.util.Set;

//import org.zu.ardulink.Link;
//import org.zu.ardulink.connection.usb.DigisparkUSBConnection;
//import org.zu.ardulink.protocol.IProtocol;
//import org.zu.ardulink.protocol.ProtocolHandler;
//import org.zu.ardulink.protocol.SimpleBinaryProtocol;



import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class BlinkLED extends JFrame {
	public static Link link = Link.createInstance("TEST");
	public static int motor1 = 4;
	public static int motor2 = 7;
	public static int speed1 = 5;
	public static int speed2 = 6;

	public static void main(String[] args) {
		JFrame frame = new BlinkLED();
		frame.setSize(1000,600);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setTitle("test programma robot");
		frame.setVisible(true);
		
		try {

            link.connect("COM7",115200);
            Thread.sleep(2000);
            System.out.println("verbinding gemaakt");   

				}
						
		catch(Exception e) {
			e.printStackTrace();
		}
		
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
        	
            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (BlinkLED.class) {
                    switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
        					link.sendPowerPinSwitch(motor1, 0);
        					link.sendPowerPinIntensity(speed1, 255);
        					System.out.println("poort 5 aan");
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_UP) {
        					link.sendPowerPinSwitch(motor2, 1);
        					link.sendPowerPinIntensity(speed2, 255);
                        	System.out.println("poort 7 aan");
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
        					link.sendPowerPinSwitch(motor2, 0);
        					link.sendPowerPinIntensity(speed2, 255);
                        	System.out.println("poort 8 aan");
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
        					link.sendPowerPinSwitch(motor1, 1);
        					link.sendPowerPinIntensity(speed1, 255);
                            System.out.println("poort 6 aan");
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

	private static Link getDigisparkConnection() {
		Set<String> protocolNames = ProtocolHandler.getInstalledProtocolImplementationNames();
		SimpleBinaryProtocol protocol = new SimpleBinaryProtocol();
		if(!protocolNames.contains(SimpleBinaryProtocol.NAME)) {
			ProtocolHandler.installProtocolImplementation(protocol);
		}
		return Link.createInstance("digisparkConnection", SimpleBinaryProtocol.NAME, new DigisparkUSBConnection("digisparkConnection", protocol.getIncomingMessageDivider()));
	}
	
}
