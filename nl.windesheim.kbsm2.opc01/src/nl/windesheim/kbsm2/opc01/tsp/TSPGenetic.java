package nl.windesheim.kbsm2.opc01.tsp;

import java.util.ArrayList;

public class TSPGenetic
{
    ArrayList<Packet> packets;

    public TSPGenetic(ArrayList<Packet> packets)
    {
        this.packets = packets;
    }

    public void activateGenetic()
    {
        packets.stream().forEach((a) ->
        {
            GeneticPathHolder.addPoint(a);
        });
        GeneticPoints pop = new GeneticPoints(50, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        pop = GeneticAlgorithm.evolvePopulation(pop);
        for (int i = 0; i < 100; i++)
        {
            pop = GeneticAlgorithm.evolvePopulation(pop);
        }

        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
}
