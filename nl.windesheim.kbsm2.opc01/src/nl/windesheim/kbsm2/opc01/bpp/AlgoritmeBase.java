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
        myAlgoritmes = new ArrayList<Algoritme2>();
    }
    
    public void AddAlgoritme(Algoritme2 alg)
    {
        myAlgoritmes.add(alg);
    }
}
