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
public class NextFit extends Algoritme2 {

    public NextFit(int doosGrootte, ArrayList<Integer> paketten) {
        super(doosGrootte, paketten);
        int sum;
        int dooscheck = 0;
        ArrayList<Integer> startdoos = new ArrayList<>(); //startdoos initialiseren
        dozen.add(startdoos);
        aantalDozen++;

        for (Integer check : paketten) { //paketten langsgaan
            sum = dozen.get(dooscheck).stream().mapToInt(Integer::intValue).sum();
            if ((sum + check) <= doosGrootte) { //checken of pakket past
                dozen.get(dooscheck).add(check); //zo ja: paket toevoegen aan huidige doos
                nieuwpakketsim(dooscheck);
            } else {
                aantalDozen++; //zo nee: huidige doos verhogen en pakket toevoegen
                ArrayList<Integer> nieuwedoos = new ArrayList<>();
                nieuwedoos.add(check);
                dozen.add(nieuwedoos);
                nieuwpakketsim(aantalDozen-1);
                dooscheck++;
            }
        }
    }

}
