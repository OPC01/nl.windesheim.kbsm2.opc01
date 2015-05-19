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
public class Algoritme2 extends AlgoritmeBase{

    private ArrayList<Integer> dozenSimulatie;
    private int doosGrootte;
    private ArrayList<Integer> paketten;
    private int overschot;
    public int aantalDozen = 0;
    public ArrayList<ArrayList<Integer>> dozen;

    public Algoritme2(int doosGrootte, ArrayList<Integer> paketten) { //ArrayList<ArrayList<Integer>> dozen
        this.doosGrootte = doosGrootte;
        this.paketten = paketten;
        //this.dozen = dozen;
    }

    public void nieuwpakketsim(int pakket, int locatie) {
        dozenSimulatie.add(pakket);
        dozenSimulatie.add(locatie);
    }

    public int getDoosGrootte() {
        return doosGrootte;
    }

    public int getAantalDozen() {
        return aantalDozen;
    }

    public void setDoosGrootte(int doosGrootte) {
        this.doosGrootte = doosGrootte;
    }

    public void setAantalDozen(int aantalDozen) {
        this.aantalDozen = aantalDozen;
    }
}
