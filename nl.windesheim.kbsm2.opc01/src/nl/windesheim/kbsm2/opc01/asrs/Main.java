package nl.windesheim.kbsm2.opc01.asrs;

import javax.swing.JFrame;

public class Main extends JFrame {

    public static void main(String[] args){
        JFrame paneel = new Paneel();
        paneel.setLocationRelativeTo(null); // positioneert frame in het midden
        paneel.setVisible(true);
    }
}
