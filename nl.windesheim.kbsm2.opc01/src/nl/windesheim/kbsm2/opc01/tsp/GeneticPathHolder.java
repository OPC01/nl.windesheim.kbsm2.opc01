package nl.windesheim.kbsm2.opc01.tsp;

import java.util.ArrayList;

public class GeneticPathHolder
{    
    
    private static ArrayList points;

    // Point toevoegen
    public static void addPoint(Packet point)
    {
        points.add(point);
    }

    // Point ophalen
    public static Packet getPacket(int index)
    {
        return (Packet) points.get(index);
    }

    // Aantal points terug krijgen
    public static int numberOfPoints()
    {
        return points.size();
    }
    
}
