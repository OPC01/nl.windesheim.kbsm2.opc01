/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.windesheim.kbsm2.opc01.bpp;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.JFrame;

/**
 *
 * @author W7Home
 */
public class CenterOnScreen extends JFrame {

    public CenterOnScreen() {

        initUI();
    }

    private void initUI() {

        setSize(250, 200);
        centerFrame();
        setTitle("Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void centerFrame() {

        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2 - 200;
        int dy = centerPoint.y - windowSize.height / 2 + 200;
        setLocation(dx, dy);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CenterOnScreen ex = new CenterOnScreen();
                ex.setVisible(true);
            }
        });
    }
}
