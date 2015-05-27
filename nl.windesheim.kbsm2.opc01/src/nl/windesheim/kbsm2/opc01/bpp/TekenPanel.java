/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.windesheim.kbsm2.opc01.bpp;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author W7Home
 */
public class TekenPanel extends JPanel {
    
    private AlgoritmeBase base;
    private ArrayList<ArrayList<Integer>> ffSim;
    private ArrayList<ArrayList<Integer>> nfSim;
    private ArrayList<ArrayList<Integer>> bfSim;

    public TekenPanel(AlgoritmeBase base) {
        this.base = base;
        ffSim = new ArrayList();
        nfSim = new ArrayList();
        bfSim = new ArrayList();
        this.doosSetup(); 
        this.setPreferredSize(new Dimension(601, 457));
        
    }
    
    public void doosSetup(){
        for(int i = 0; i < base.getLengte(); i++){ //checken welke checkboxes zijn aangekruist
            switch(base.getAlogritme(i).getAlgoritmeNaam()){
                case "FirstFit": //checken via getnaam methode
                    for(int ff = 0; ff < base.getAlogritme(i).getAantalDozen(); ff++){ //2d simulatielijst kolommen initialiseren
                        ArrayList<Integer> ffSetup = new ArrayList();
                        ffSim.add(ffSetup);
                    }break;
                case "BestFit": 
                    for(int bf = 0; bf < base.getAlogritme(i).getAantalDozen(); bf++){
                        ArrayList<Integer> bfSetup = new ArrayList();
                        bfSim.add(bfSetup);
                    }break;
                case "NextFit": 
                    for(int nf = 0; nf < base.getAlogritme(i).getAantalDozen(); nf++){
                        ArrayList<Integer> nfSetup = new ArrayList();
                        nfSim.add(nfSetup);
                    }break;
            }
        }
    }
       
    public void addNieuw(int algoritme){
        switch (base.getAlogritme(algoritme).getAlgoritmeNaam()){ //checken aan getnaam methode welk algoritme het is
            case "FirstFit": //pakket toevoegen aan doos
                ffSim.get( (int) base.getAlogritme(algoritme).getDozenSimulatie().get(0)).add( (int) base.getAlogritme(algoritme).getPaketten().get(0));
                break;
            case "BestFit":
                bfSim.get( (int) base.getAlogritme(algoritme).getDozenSimulatie().get(0)).add( (int) base.getAlogritme(algoritme).getPaketten().get(0));
                break;
            case "NextFit":
                nfSim.get( (int) base.getAlogritme(algoritme).getDozenSimulatie().get(0)).add( (int) base.getAlogritme(algoritme).getPaketten().get(0));
                break;
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("calibri", Font.PLAIN, 13)); //font instellen

        for(int i = 0; i < base.getLengte(); i++){ //per algoritmebase object langsgaan
            this.addNieuw(i);    //nieuw pakket toevoegen
            base.getAlogritme(i).getDozenSimulatie().remove(0); //index 0 van simulatie verwijderen
        }
        base.getAlogritme(0).getPaketten().remove(0);  //index 0 van paketten verwijderen
               
        int ffy = 0; //instellen hoogtecheck teller
        for(int ff = 0; ff < ffSim.size(); ff++){ //2d arraylist langsgaan (x as)
            ffy = 0;
            for(int ffdoos = 0; ffdoos < ffSim.get(ff).size(); ffdoos++){ //(y as)
                ffy += ffSim.get(ff).get(ffdoos); //hoogtecheck verhogen
                g.setColor(Color.GREEN); //pakket tekenen
                g.fillRect(ff *30 + 10, 114 - ffy *10, 20, ffSim.get(ff).get(ffdoos)*10);
                g.setColor(Color.BLACK);
                g.drawRect(ff *30 + 10, 114 - ffy *10, 20, ffSim.get(ff).get(ffdoos)*10);
                g.drawString(String.valueOf(ffSim.get(ff).get(ffdoos)), ff*30 + 15, 114 - (ffy *10 -ffSim.get(ff).get(ffdoos)*5-5));
            }
        }
        int bfy = 0; 
        for(int bf = 0; bf < bfSim.size(); bf++){
            bfy = 0;
            for(int bfdoos = 0; bfdoos < bfSim.get(bf).size(); bfdoos++){
                bfy += bfSim.get(bf).get(bfdoos); 
                g.setColor(Color.RED);
                g.fillRect(bf *30 + 10, 228 - bfy *10, 20, bfSim.get(bf).get(bfdoos)*10);
                g.setColor(Color.BLACK);
                g.drawRect(bf *30 + 10, 228 - bfy *10, 20, bfSim.get(bf).get(bfdoos)*10);
                g.drawString(String.valueOf(bfSim.get(bf).get(bfdoos)), bf*30 + 15, 228 - (bfy *10 -bfSim.get(bf).get(bfdoos)*5-5));
            }
        }
        int nfy = 0;
        for(int nf = 0; nf < nfSim.size(); nf++){
            nfy = 0;
            for(int nfdoos = 0; nfdoos < nfSim.get(nf).size(); nfdoos++){
                nfy += nfSim.get(nf).get(nfdoos); 
                g.setColor(Color.ORANGE);
                g.fillRect(nf *30 + 10, 342 - nfy *10, 20, nfSim.get(nf).get(nfdoos)*10);
                g.setColor(Color.BLACK);
                g.drawRect(nf *30 + 10, 342 - nfy *10, 20, nfSim.get(nf).get(nfdoos)*10);
                g.drawString(String.valueOf(nfSim.get(nf).get(nfdoos)), nf*30 + 15, 342 - (nfy *10 -nfSim.get(nf).get(nfdoos)*5-5));
            }
        }
        
        g.setColor(Color.BLACK); //extra lijnen en tekst tekenen
        g.drawRect(0,0,600,456);
        g.drawString("FirstFit", 2, 11);
        g.drawString("BestFit", 2, 125);
        g.drawString("NextFit", 2, 239);
        g.drawString("Paketten", 2, 353);
        for(int line = 0; line < 4; line++){
            g.drawLine(0, (line+1)*114, 600,(line+1)*114);
        }
        
        for(int pakket = 0; pakket < base.getAlogritme(0).getPaketten().size(); pakket ++){ //pakettenlijst langsgaan
            g.setColor(Color.LIGHT_GRAY); //paketten tekenen
            g.fillRect(pakket *30 + 10, 456 - (int) base.getAlogritme(0).getPaketten().get(pakket)*10 , 20, (int) base.getAlogritme(0).getPaketten().get(pakket)*10);
            g.setColor(Color.BLACK);
            g.drawRect(pakket *30 + 10, 456 - (int) base.getAlogritme(0).getPaketten().get(pakket)*10 , 20, (int) base.getAlogritme(0).getPaketten().get(pakket)*10);
            g.drawString(String.valueOf((int) base.getAlogritme(0).getPaketten().get(pakket)), pakket*30 + 15, 456 - (int) base.getAlogritme(0).getPaketten().get(pakket)*5+5);        
        }    
    }
}

