/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author W7Home
 */
public class TekenTest extends JPanel {

    private Algoritme2 algoritme1;
    private ArrayList dozenSimulatie;
    private ArrayList doosjes;
    private ArrayList posities;
    private int doosGrootte;
    private int aantalDozen;
    private int aantalKeerInDeZelfdeDoos = 0;

    public TekenTest(Algoritme2 algoritme1) {
        this.algoritme1 = algoritme1;
        this.setPreferredSize(new Dimension(200, 400));
        System.out.println("print");
        dozenSimulatie = algoritme1.getDozenSimulatie();
        aantalDozen = algoritme1.getAantalDozen();
        doosGrootte = algoritme1.getDoosGrootte();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        splitUp();
        setBackground(Color.WHITE);
        int unit = 10;
        int x = 4 * unit;
        int y = 4 * unit;
        int afm1 = 8 * unit;
        int lengteDoos = 26 * unit;
        int afm = 10 * unit;
        int unitsPerDoos = doosGrootte * unit;
        int pixelPerUnit = lengteDoos / unitsPerDoos;
        int overgeblevenRuimte = lengteDoos;

        // het pakket is een groote van 80 bij 260 pixels
        System.out.println("paintComponent");

        for (int i = 1; i <= aantalDozen; i++) {
            int pakOpDoosje = 0;
            meerdereDozenInEenPakket();
            if (aantalKeerInDeZelfdeDoos >= 2) {
                for (int j = 0; j < aantalKeerInDeZelfdeDoos; j++) {
                    int dropOfDoosje = (int) doosjes.get(pakOpDoosje);
                    int unitGrootteVanDoosje = dropOfDoosje * unit;
                    int pixelPerDoosje = unitGrootteVanDoosje * pixelPerUnit;
                    overgeblevenRuimte = overgeblevenRuimte - pixelPerDoosje;
//                    System.out.println(unitsPerDoos);
//                    System.out.println(pixelPerUnit);
//                    System.out.println(dropOfDoosje);
//                    System.out.println(unitGrootteVanDoosje);
//                    System.out.println(pixelPerDoosje);
                    g.setColor(Color.GREEN);
                    g.fillRect(x, y, afm1, pixelPerDoosje);
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, afm1, pixelPerDoosje);

                    System.out.println("doos");
                    y = y + pixelPerDoosje;
                    pakOpDoosje++;
                }
                if (overgeblevenRuimte != 0) {
                    g.setColor(Color.RED);
                    g.fillRect(x, y, afm1, overgeblevenRuimte);
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, afm1, overgeblevenRuimte);
//                    System.out.println("Overgebleven ruimte");
                    overgeblevenRuimte = lengteDoos;
                }
            } else {
                int dropOfDoosje = (int) doosjes.get(pakOpDoosje);
                int unitGrootteVanDoosje = dropOfDoosje * unit;
                int pixelPerDoosje = unitGrootteVanDoosje * pixelPerUnit;
                overgeblevenRuimte = overgeblevenRuimte - pixelPerDoosje;
                g.setColor(Color.GREEN);
                g.fillRect(x, y, afm1, pixelPerDoosje);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, afm1, pixelPerDoosje);
                y = y + pixelPerDoosje;
                g.setColor(Color.RED);
                g.fillRect(x, y, afm1, overgeblevenRuimte);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, afm1, overgeblevenRuimte);
//                System.out.println("Overgebleven ruimte2");
                overgeblevenRuimte = lengteDoos;
            }
            x += afm;
            aantalKeerInDeZelfdeDoos = 0;
            y = 4 * unit;
        }
    }

    public void splitUp() {
        doosjes = new ArrayList<>();
        posities = new ArrayList<>();
        for (int l = 0; l < dozenSimulatie.size(); l = l + 2) {
            doosjes.add(dozenSimulatie.get(l));
        }
        for (int a = 1; a < dozenSimulatie.size(); a = a + 2) {
            posities.add(dozenSimulatie.get(a));
        }
        System.out.println(doosjes);
        System.out.println(posities);
    }

    public void meerdereDozenInEenPakket() {
        boolean dubbel = false;
        boolean driedubbel = false;
        boolean vierdubbel = false;
        boolean vijfdubbel = false;
        boolean zesdubbel = false;
        boolean zevendubbel = false;
        boolean achtdubbel = false;
        boolean negendubbel = false;
        boolean tiendubbel = false;
        int groottePosities = posities.size();
        for (int i = 0; i < groottePosities - 1; i++) {
            if (groottePosities >= 2) {
                if ((int) posities.get(i) == (int) posities.get(i + 1)) {
                    dubbel = true;
                }
                if (groottePosities >= 3) {
                    if (dubbel && (int) posities.get(i) == (int) posities.get(i + 1)) {
                        dubbel = false;
                        driedubbel = true;
                    }
                    if (groottePosities >= 4) {
                        if (driedubbel && (int) posities.get(i) == (int) posities.get(i + 1)) {
                            driedubbel = false;
                            vierdubbel = true;
                        }
                        if (groottePosities >= 5) {
                            if (vierdubbel && (int) posities.get(i) == (int) posities.get(i + 1)) {
                                vierdubbel = false;
                                vijfdubbel = true;
                            }
                            if (groottePosities >= 6) {
                                if (vijfdubbel && (int) posities.get(i) == (int) posities.get(i + 1)) {
                                    vijfdubbel = false;
                                    zesdubbel = true;
                                }
                                if (groottePosities >= 7) {
                                    if (zesdubbel && (int) posities.get(i) == (int) posities.get(i + 1)) {
                                        zesdubbel = false;
                                        zevendubbel = true;
                                    }
                                    if (groottePosities >= 8) {
                                        if (zevendubbel && (int) posities.get(i) == (int) posities.get(i + 1)) {
                                            zevendubbel = false;
                                            achtdubbel = true;
                                        }
                                        if (groottePosities >= 9) {
                                            if (achtdubbel && (int) posities.get(i) == (int) posities.get(i + 1)) {
                                                achtdubbel = false;
                                                negendubbel = true;
                                            }
                                            if (groottePosities >= 10) {
                                                if (negendubbel && (int) posities.get(i) == (int) posities.get(i + 1)) {
                                                    negendubbel = false;
                                                    tiendubbel = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (dubbel) {
                aantalKeerInDeZelfdeDoos = 2;
            }
            if (driedubbel) {
                aantalKeerInDeZelfdeDoos = 3;
            }
            if (vierdubbel) {
                aantalKeerInDeZelfdeDoos = 4;
            }
            if (vijfdubbel) {
                aantalKeerInDeZelfdeDoos = 5;
            }
            if (zesdubbel) {
                aantalKeerInDeZelfdeDoos = 6;
            }
            if (zevendubbel) {
                aantalKeerInDeZelfdeDoos = 7;
            }
            if (achtdubbel) {
                aantalKeerInDeZelfdeDoos = 8;
            }
            if (negendubbel) {
                aantalKeerInDeZelfdeDoos = 9;
            }
            if (tiendubbel) {
                aantalKeerInDeZelfdeDoos = 10;
            }
        }
    }

}
