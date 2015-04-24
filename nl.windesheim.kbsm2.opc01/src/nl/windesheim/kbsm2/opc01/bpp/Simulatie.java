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
public class Simulatie extends JFrame {

    private Algoritme algoritme1;
    private TekenPanel paneel;

    public Simulatie(Algoritme algoritme1) {
        this.algoritme1 = algoritme1;
        setSize(500, 500);
        setFrame();
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.paneel = new TekenPanel(algoritme1);
        add(paneel);
        setVisible(true);
    }

    private void setFrame() {
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2 - 200;
        int dy = centerPoint.y - windowSize.height / 2 + 200;
        setLocation(dx, dy);
    }
}