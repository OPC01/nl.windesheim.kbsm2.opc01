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
        ArrayList<Integer> startdoos = new ArrayList<>();
        dozen.add(startdoos);
        aantalDozen++;

        for (Integer check : paketten) {
            sum = dozen.get(dooscheck).stream().mapToInt(Integer::intValue).sum();
            if ((sum + check) <= doosGrootte) {
                dozen.get(dooscheck).add(check);
                nieuwpakketsim(check, dooscheck);
            } else {
                aantalDozen++;
                ArrayList<Integer> nieuwedoos = new ArrayList<>();
                nieuwedoos.add(check);
                dozen.add(nieuwedoos);
                nieuwpakketsim(check, dooscheck);
                dooscheck++;
            }
        }
        for (int i = 0; i < dozen.size(); i++) {
            System.out.println("Next Fit");
            System.out.println(dozen.get(i));
        }
    }

}
