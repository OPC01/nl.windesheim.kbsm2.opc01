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

    private ArrayList<Algoritme2> myAlgoritmes;
    
    public AlgoritmeBase(){
        myAlgoritmes = new ArrayList<Algoritme2>();// dit is de lijst met de algoritmen aan de hand van deze lijst kunnen we de resultaten in kijken
    }
    
    public int getLengte(){
        return myAlgoritmes.size();
    }
    
    public void addAlgoritme(Algoritme2 alg)
    {
        myAlgoritmes.add(alg);
    }
    
    public Algoritme2 getAlogritme(int i){
        return myAlgoritmes.get(i);
    }
}
