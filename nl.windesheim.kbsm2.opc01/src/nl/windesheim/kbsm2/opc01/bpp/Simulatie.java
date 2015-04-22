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
public class Simulatie extends JFrame{
    private Algoritme algoritme1;
    private TekenPanel paneel;
    
    public Simulatie(Algoritme algoritme1){
        this.algoritme1 = algoritme1;
        setSize(300, 800);
        setLayout (new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Simulatie ");
        
        this.paneel = new TekenPanel(algoritme1);
        add(paneel);
        setVisible(true);
    }
}
