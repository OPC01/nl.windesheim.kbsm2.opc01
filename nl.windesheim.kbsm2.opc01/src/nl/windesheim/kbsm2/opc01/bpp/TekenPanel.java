/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.windesheim.kbsm2.opc01.bpp;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author W7Home
 */
public class TekenPanel extends JPanel {

    private Algoritme2 algoritme1;

    public TekenPanel(Algoritme2 algoritme1) {
        this.algoritme1 = algoritme1;
        this.setPreferredSize(new Dimension(200, 200));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x2 = 40; //dit is de lengte van een doos die 1 unit groot is
        int x = 40;
        int y = 80;
        int afm1 = 80;
        int afm2 = 40;
        int afm = 100;
        

        for (int i = 0; i < algoritme1.getAantalDozen(); i++) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, afm1, afm2);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, afm1, afm2);
            x += afm;
        }
    }
}
