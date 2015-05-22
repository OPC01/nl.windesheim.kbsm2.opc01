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
        //Collections.sort(paketten);
        //Collections.reverse(paketten);
        int sum;
        int bestFit = 0;
        boolean doosvol = true;

        ArrayList<Integer> startdoos = new ArrayList<Integer>();
        startdoos.add(0);
        dozen.add(startdoos); //startdoos aanmaken

        for (Integer pakket : paketten) { 
            bestFit = 0;
            doosvol = true;
            for (int doos = 1; doos < dozen.size(); doos++) {
                sum = dozen.get(doos).stream().mapToInt(Integer::intValue).sum();
                //System.out.println(sum);
                if (((sum + pakket) <= doosGrootte) && ((sum + pakket) > (pakket + dozen.get(bestFit).stream().mapToInt(Integer::intValue).sum()))) {
                    bestFit = doos;
                    doosvol = false;
                }
                //System.out.println("sum = " + sum + ", bestFit = " + bestFit);
            }
            if (!doosvol) {
                dozen.get(bestFit).add(pakket);
                nieuwpakketsim(pakket, bestFit - 1);
            } else {
                aantalDozen++;
                ArrayList<Integer> nieuwedoos = new ArrayList<Integer>();
                nieuwedoos.add(pakket);
                dozen.add(nieuwedoos);
                nieuwpakketsim(pakket, aantalDozen - 1);
            }
        }
        dozen.remove(0);
        for (int i = 0; i < dozen.size(); i++) {
            System.out.println("Best Fit");
            System.out.println(dozen.get(i));
        }
    }
}
