package nl.windesheim.kbsm2.opc01.asrs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author vanDijk
 */
public class Teken extends JPanel {

    // aantal vakken in X- en Y-as
    int aantalX = 5;
    int aantalY = 5;

    ArrayList<String> posXYGevuld = new ArrayList<>();
    ArrayList<String> posXYGeleegd = new ArrayList<>();
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // test met gevulde meuk
        posXYGevuld.add("1.1");
        posXYGevuld.add("2.1");
        posXYGevuld.add("3.1");
        posXYGeleegd.add("4.1"); // geleegd
        posXYGeleegd.add("5.1"); // geleegd

        for (int yy = 1; yy <= aantalY; yy++) { // xx telt vanaf 1 omdat 0.x niet meedoet
            // b=breedte, h=hoogte, y=y-as, x=x-as
            int b=80, h=40, y=(yy*h), x=500;

            for (int xx = 1; xx <= aantalX; xx++) {
                // check gevuld
                if(posXYGevuld.contains(yy+"."+xx)) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(x, y, b, h);
                }
                // check geleegd
                if(posXYGeleegd.contains(yy+"."+xx)) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x, y, b, h);
                }

                g.setColor(Color.BLACK);
                g.drawRect(x, y, b, h);

                x+=b;
                System.out.println(yy+"."+xx);
            }
        }
        
        
//        repaint();
    }
    
}
