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
public class TekenPanel extends JPanel{
    private Algoritme algoritme1;
    
    public TekenPanel(Algoritme algoritme1){
        this.algoritme1 = algoritme1;
        this.setPreferredSize(new Dimension(300,400));
    }
}
