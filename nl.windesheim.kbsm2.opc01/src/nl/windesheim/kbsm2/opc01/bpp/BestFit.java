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
public class BestFit extends Algoritme2 {

    public BestFit(int doosGrootte, ArrayList<Integer> paketten) {
        super(doosGrootte, paketten);

        int sum;
        int bestFit = 0;
        boolean doosvol = true;

        ArrayList<Integer> startdoos = new ArrayList<>();
        startdoos.add(0);
        dozen.add(startdoos); //startdoos aanmaken

        for (Integer pakket : paketten) { //paketten langsgaan
            bestFit = 0; //bestfitdoos resetten
            doosvol = true;
            for (int doos = 1; doos < dozen.size(); doos++) { //dozen langsgaan
                sum = dozen.get(doos).stream().mapToInt(Integer::intValue).sum();
                if (((sum + pakket) <= doosGrootte) && ((sum + pakket) > (pakket + dozen.get(bestFit).stream().mapToInt(Integer::intValue).sum()))) {
                    bestFit = doos; //checken of som van doos inclusief pakket groter is dan eerst
                    doosvol = false;
                }
            }
            if (!doosvol) { //beste pakket is gevonden
                dozen.get(bestFit).add(pakket); //voeg pakket toe aan beste doos
                nieuwpakketsim(bestFit - 1);
            } else {
                aantalDozen++; //geen passende doos gevonden
                ArrayList<Integer> nieuwedoos = new ArrayList<>(); //maak nieuwe doos aan en voeg pakket toe aan doos
                nieuwedoos.add(pakket);
                dozen.add(nieuwedoos);
                nieuwpakketsim(aantalDozen - 1);
            }
        }
        dozen.remove(0); //startdoos verwijderen
    }
}
