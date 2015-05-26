/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

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
    
    public int getLengte(){
        return myAlgoritmes.size();
    }
    
    public void AddAlgoritme(Algoritme2 alg)
    {
        myAlgoritmes.add(alg);
    }
    
    public Algoritme2 getAlogritme(int i){
        return myAlgoritmes.get(i);
    }
    
    public String toString(){
        return "sadasd";//getAlgoritme(1)+"gg";
        
        //delete this at end
    }
}
