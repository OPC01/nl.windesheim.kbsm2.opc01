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
public class TekenPaneel extends JPanel {

    private Algoritme2 algoritme1;

    public TekenPaneel(Algoritme2 algoritme1) {
        this.algoritme1 = algoritme1;
        this.setPreferredSize(new Dimension(200, 400));
        System.out.println("print");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        int x = 40;
        int y = 40;
        int afm1 = 80;
        int afm2 = 250;
        int afm = 100;
        System.out.println("tekenTest");
        System.out.println(algoritme1.getAantalDozen());

//        if(algoritme1.getAantalDozen() > 5){
//            afm1 =- algoritme1.getAantalDozen();
//            System.out.println("dozentest");
//        }
//        
//
        for (int i = 1; i <= algoritme1.getAantalDozen(); i++) {
            g.setColor(Color.RED);
            g.fillRect(x, y, afm1, afm2);
            System.out.println("doos");
//            g.setColor(Color.BLACK);
//            g.drawRect(x, y, afm1, afm2);
            x += afm;
        }

        for (int j = 0; j < 5; j++) {
            int x2 = 40;
            int y2 = 300;
            g.setColor(Color.black);
            g.drawRect(x2, y2, 80, 80);
            System.out.println("pakket");
            x2 += afm;
        }
    }
}
