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
public class FirstFit extends Algoritme2 {

    /**
     *
     */
    public FirstFit(int doosGrootte, ArrayList<Integer> paketten) { //ArrayList<ArrayList<Integer>> dozen
        super(doosGrootte, paketten);
        int sum;

        paketten:
        for (Integer check : paketten) {
            for (int doos = 0; doos < dozen.size(); doos++) {
                sum = dozen.get(doos).stream().mapToInt(Integer::intValue).sum();
                //sum = berekenSum(dozen.get(doos));
                if ((sum + check) <= doosGrootte) {
                    dozen.get(doos).add(check);
                    nieuwpakketsim(check, doos);
                    continue paketten;
                }
            }
            aantalDozen++;
            ArrayList<Integer> nieuwedoos = new ArrayList<Integer>();
            nieuwedoos.add(check);
            dozen.add(nieuwedoos);
            nieuwpakketsim(check, aantalDozen - 1);
        }
    }
}
