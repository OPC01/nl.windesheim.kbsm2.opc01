package nl.windesheim.kbsm2.opc01.tsp;

import java.util.*;
import javax.swing.*;

public class Main
{

    public static void main(String[] args)
    {
        MainScreen m = new MainScreen();
        m.setVisible(true);        
        /*
         DistanceMap z = new DistanceMap();
         Packet f = new Packet(0, 1);
         Packet a = new Packet(0, 2);
         Packet b = new Packet(0, 3);
         Packet c = new Packet(0, 4);
         Packet d = new Packet(0, 5);
         Packet e = new Packet(1, 6);
         ArrayList<Packet> list = new ArrayList<Packet>();
         list.add(f);
         list.add(a);
         list.add(b);
         list.add(c);
         list.add(d);
         list.add(e);
         z.createMatrix(list);
         TSPNearestNeighbour x = new TSPNearestNeighbour();
         x.tsp(z.getMap());
         System.out.println(Arrays.deepToString(z.getMap()));
         x.calculatePathLength(z.getMap(), list);
         System.out.println(x.getLengthOfPath());
         ArrayList<Integer> y = x.getPath();
             
        
         // Create and add our cities
         Packet city = new Packet(60, 200);
         GeneticPathHolder.addPoint(city);
         Packet city2 = new Packet(180, 200);
         GeneticPathHolder.addPoint(city2);
         Packet city3 = new Packet(80, 180);
         GeneticPathHolder.addPoint(city3);
         Packet city4 = new Packet(140, 180);
         GeneticPathHolder.addPoint(city4);
         Packet city5 = new Packet(20, 160);
         GeneticPathHolder.addPoint(city5);
         Packet city6 = new Packet(100, 160);
         GeneticPathHolder.addPoint(city6);
         Packet city7 = new Packet(200, 160);
         GeneticPathHolder.addPoint(city7);
         Packet city8 = new Packet(140, 140);
         GeneticPathHolder.addPoint(city8);
         Packet city9 = new Packet(40, 120);
         GeneticPathHolder.addPoint(city9);
         Packet city10 = new Packet(100, 120);
         GeneticPathHolder.addPoint(city10);
         Packet city11 = new Packet(180, 100);
         GeneticPathHolder.addPoint(city11);
         Packet city12 = new Packet(60, 80);
         GeneticPathHolder.addPoint(city12);
         Packet city13 = new Packet(120, 80);
         GeneticPathHolder.addPoint(city13);
         Packet city14 = new Packet(180, 60);
         GeneticPathHolder.addPoint(city14);
         Packet city15 = new Packet(20, 40);
         GeneticPathHolder.addPoint(city15);
         Packet city16 = new Packet(100, 40);
         GeneticPathHolder.addPoint(city16);
         Packet city17 = new Packet(200, 40);
         GeneticPathHolder.addPoint(city17);
         Packet city18 = new Packet(20, 20);
         GeneticPathHolder.addPoint(city18);
         Packet city19 = new Packet(60, 20);
         GeneticPathHolder.addPoint(city19);
         Packet city20 = new Packet(160, 20);
         GeneticPathHolder.addPoint(city20);

         // Initialize population
         GeneticPoints pop = new GeneticPoints(50, true);
         System.out.println("Initial distance: " + pop.getFittest().getDistance());

         // Evolve population for 100 generations
         pop = GeneticAlgorithm.evolvePopulation(pop);
         for (int i = 0; i < 100; i++)
         {
         pop = GeneticAlgorithm.evolvePopulation(pop);
         }

         // Print final results
         System.out.println("Finished");
         System.out.println("Final distance: " + pop.getFittest().getDistance());
         System.out.println("Solution:");
         System.out.println(pop.getFittest());
         */
    }
}
