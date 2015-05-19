package nl.windesheim.kbsm2.opc01.asrs;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class Main extends JFrame {

    public static void main(String[] args){
        JFrame paneel = new Paneel();
        paneel.setLocationRelativeTo(null); // positioneert frame in het midden
        paneel.setVisible(true);
    }
}
