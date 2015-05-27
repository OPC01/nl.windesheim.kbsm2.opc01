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
    public int aantalDozen = 0;
    public ArrayList<ArrayList<Integer>> dozen;

    public Algoritme2(int doosGrootte, ArrayList<Integer> paketten) { //dit is de basis klasse van elk alogrimte
        this.doosGrootte = doosGrootte;
        this.paketten = paketten;
        dozen  = new ArrayList<>();
        dozenSimulatie = new ArrayList<>();
    }

    public void nieuwpakketsim(int locatie) {
        dozenSimulatie.add(locatie);

    }
    
    public String getAlgoritmeNaam(){// hiermee halen we de naam van het algoritme op
        if(this instanceof FirstFit){
            return "FirstFit";
        }else if(this instanceof NextFit){
            return "NextFit";
        }else{
            return "BestFit";
        }
    }
    
    public int getLowerbound(){//hiermee wordt het minimum aantal pakketten (dus hoeveel pakketten er minimaal nodig zijn om de dozen er in te passen)
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
    
    public void testPrint(){// deze print de lijst met dozen en de positie van de dozen die later in de pakketten verdwijnen
        System.out.println(dozenSimulatie);
    }

    public int getDoosGrootte() {
        return doosGrootte;
    }
    
    public ArrayList<Integer> getPaketten(){
        return paketten;
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
