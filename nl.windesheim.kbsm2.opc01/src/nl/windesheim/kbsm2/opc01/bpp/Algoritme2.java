/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.windesheim.kbsm2.opc01.bpp;

import java.util.ArrayList;

/**
 *
 * @author W7Home
 */
public class Algoritme2 {
    private int doosGrootte;
    private ArrayList<Integer> paketten;
    private int overschot;
    private int aantalDozen = 0;
    private ArrayList<ArrayList<Integer>> dozen;
    
    public Algoritme2(int doosGrootte){
        this.doosGrootte = doosGrootte;
    }
}
