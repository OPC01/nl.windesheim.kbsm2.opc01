package nl.windesheim.kbsm2.opc01.tsp;

import java.util.ArrayList;

public class GeneticPathHolder
{
    private ArrayList points;
    
    public GeneticPathHolder(ArrayList<Packet> points)
    {
        this.points= points;
    }       

    // Point toevoegen
    public void addPoint(Packet point)
    {
        points.add(point);
    }

    // Point ophalen
    public Packet getPacket(int index)
    {
        return (Packet) points.get(index);
    }

    // Aantal points terug krijgen
    public int numberOfPoints()
    {
        return points.size();
    }
    
}
