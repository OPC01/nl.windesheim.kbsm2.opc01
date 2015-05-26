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
public class Algoritme2{

    private ArrayList<Integer> dozenSimulatie;
    private int doosGrootte;
    private ArrayList<Integer> paketten;
    //private int overschot;
    public int aantalDozen = 0;
    public ArrayList<ArrayList<Integer>> dozen;

    public Algoritme2(int doosGrootte, ArrayList<Integer> paketten) { //ArrayList<ArrayList<Integer>> dozen
        this.doosGrootte = doosGrootte;
        this.paketten = paketten;
        dozen  = new ArrayList<>();
        dozenSimulatie = new ArrayList<>();
        
        //this.dozen = dozen;
    }

    public void nieuwpakketsim(int pakket, int locatie) {
        dozenSimulatie.add(pakket);
        dozenSimulatie.add(locatie);

    }
    
    public String getAlgoritmeNaam(){
        if(this instanceof FirstFit){
            return "FirstFit";
        }else if(this instanceof NextFit){
            return "NextFit";
        }else{
            return "BestFit";
        }
    }
    
    public int getLowerbound(){
        return (int) Math.ceil(paketten.stream().mapToInt(Integer::intValue).sum() / (double) doosGrootte);
    }
    
    
    public int getMaxOverschot(){
        int maxoverschot = 0;
        int sum;
        
        for(int doos = 0; doos < dozen.size(); doos++){
            sum = 0;
            for(int sumadd : dozen.get(doos)){
			sum += sumadd;
		}
            if(sum > maxoverschot){
                maxoverschot = sum;
            }
        }
        return maxoverschot;
    }
    
    public int getOverschot(){  
        int overschot = 0;
	int sum;
	System.out.println("overschot berekenen");
	for(int doos = 0; doos < dozen.size(); doos++){
		sum = 0;
		for(int sumadd : dozen.get(doos)){
			sum += sumadd;
		}
		 overschot += doosGrootte - sum;
		
	}
	return overschot;
    }
    
    public void testPrint(){
        System.out.println(dozenSimulatie);
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
    
    public ArrayList getDozenSimulatie(){
        return dozenSimulatie;
    }

//    public void setAantalDozen(int aantalDozen) {
//        this.aantalDozen = aantalDozen;
//    }
}
