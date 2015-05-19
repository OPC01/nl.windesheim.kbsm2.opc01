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
public class AlgoritmeBase{
    private boolean firstFit = false;
    private boolean bestFit = false;
    private boolean nextFit = false;
    
    private ArrayList<Algoritme2> myAlgoritmes;
    
    public AlgoritmeBase(){
        myAlgoritmes = new ArrayList<Algoritme2>();
    }
    
    public void AddAlgoritme(Algoritme2 alg)
    {
        myAlgoritmes.add(alg);
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
    
    public boolean getFirstFit() {
        return firstFit;
    }

    public boolean getBestFit() {
        return bestFit;
    }

    public boolean getNextFit() {
        return nextFit;
    }
}
