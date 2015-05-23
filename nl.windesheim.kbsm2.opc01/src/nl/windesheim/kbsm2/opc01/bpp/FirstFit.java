/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.windesheim.kbsm2.opc01.bpp;

import java.util.ArrayList;

public class FirstFit extends Algoritme2 {

    public FirstFit(int doosGrootte, ArrayList<Integer> paketten) { //ArrayList<ArrayList<Integer>> dozen
        super(doosGrootte, paketten);
        int sum;

        paketten:
        for (Integer check : paketten) { //per pakket inpakken
            for (int doos = 0; doos < dozen.size(); doos++) { //per doos kijken of het pakket past
                sum = dozen.get(doos).stream().mapToInt(Integer::intValue).sum();
                if ((sum + check) <= doosGrootte) {
                    dozen.get(doos).add(check); //zo ja: voeg pakket aan doos toe en ga na volgende pakket
                    nieuwpakketsim(check, doos); 
                    continue paketten;
                }
            }
            aantalDozen++; //zo nee: maar nieuwe doos aan en voeg pakket toe
            ArrayList<Integer> nieuwedoos = new ArrayList<>();
            nieuwedoos.add(check);
            dozen.add(nieuwedoos);
            nieuwpakketsim(check, aantalDozen - 1); //nieuwepakketsum is voor simulatie uitvoer
        }
    }
}
