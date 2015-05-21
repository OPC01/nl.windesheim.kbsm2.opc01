package nl.windesheim.kbsm2.opc01.tsp;

import nl.windesheim.kbsm2.opc01.asrs.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author vanDijk
 */
public class Teken1 extends JPanel
{

    // aantal vakken in X- en Y-as
    int aantalX = 5;
    int aantalY = 5;

    private ArrayList<Packet> packets;
    private Point checkboxSizes;

    public Teken1(ArrayList<Packet> packets, Point checkboxSizes)
    {
        this.packets = packets;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (int yy = 1; yy <= aantalY; yy++)
        { // xx telt vanaf 1 omdat 0.x niet meedoet
            // b=breedte, h=hoogte, y=y-as, x=x-as
            int b = 20, h = 20, y = (yy * h), x = 10;

            for (int xx = 1; xx <= aantalX; xx++)
            {
                g.setColor(Color.BLACK);
                g.drawRect(x, y, b, h);

                x += b;
                System.out.println(yy + "." + xx);
            }
        }

//        repaint();
    }

}
