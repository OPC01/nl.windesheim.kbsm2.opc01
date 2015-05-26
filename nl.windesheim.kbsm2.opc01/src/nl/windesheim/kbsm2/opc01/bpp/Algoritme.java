/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.windesheim.kbsm2.opc01.bpp;

import java.util.*;

/**
 *
 * @author W7Home
 */
public class Algoritme {

    private String naam;
    private boolean firstFit = false;
    private boolean bestFit = false;
    private boolean nextFit = false;

    private int doosGrootte;
    private ArrayList<Integer> paketten;
    private int overschot;
    private int aantalDozen = 0;
    private ArrayList<ArrayList<Integer>> dozen;

    public Algoritme(String naam) {
        this.naam = naam;
    }

    public void algoritmeFirstFit() {
        int sum;
        paketten:
        for (Integer check : paketten) {
            for (int doos = 0; doos < dozen.size(); doos++) {
                sum = dozen.get(doos).stream().mapToInt(Integer::intValue).sum();
                if ((sum + check) <= doosGrootte) {
                    dozen.get(doos).add(check);
                    continue paketten;
                }
            }
            aantalDozen++;
            ArrayList<Integer> nieuwedoos = new ArrayList<Integer>();
            nieuwedoos.add(check);
            dozen.add(nieuwedoos);
        }
    }

    public void algoritmeBestFit() {

    }

    public void algoritmeNextFit() {

    }
    
    public int getDoosGrootte(){
        return doosGrootte;
    }
    public int getAantalDozen(){
        return aantalDozen;
    }

    public boolean getFirstFit() {
        return firstFit;
    }

    public boolean getBestFit() {
        return bestFit;
    }

    public boolean getNextFit() {
        return nextFit;
    }

    public void setFirstFit(boolean firstFit) {
        this.firstFit = firstFit;
    }

    public void setBestFit(boolean bestFit) {
        this.bestFit = bestFit;
    }

    public void setNextFit(boolean nextFit) {
        this.nextFit = nextFit;
    }
    
    public void setDoosGrootte(int doosGrootte){
        this.doosGrootte = doosGrootte;
    }
    
    public void setAantalDozen( int aantalDozen){
        this.aantalDozen = aantalDozen;
    }

}
