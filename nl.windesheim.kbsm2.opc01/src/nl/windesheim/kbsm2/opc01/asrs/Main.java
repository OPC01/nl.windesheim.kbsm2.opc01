package nl.windesheim.kbsm2.opc01.asrs;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class Main extends JFrame {
	
	public static void main(String[] args){

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        try {
        	XMLReader XMLReader = new XMLReader();
        	File file = new File("test.xml");
            Order order = XMLReader.readXML(file);
            System.out.println(order.toString());
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
		
		JFrame paneel = new Paneel();
		paneel.setLocation(600, 300);
		paneel.setVisible( true );
	}
}
