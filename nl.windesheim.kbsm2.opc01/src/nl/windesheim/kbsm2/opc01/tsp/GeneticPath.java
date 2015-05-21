package nl.windesheim.kbsm2.opc01.tsp;

import java.util.ArrayList;
import java.util.Collections;

public class GeneticPath
{    
    private ArrayList<Packet> packets = new ArrayList<Packet>();
    
    private double fitness = 0;
    private int distance = 0;

    
    public GeneticPath()
    {
        for (int i = 0; i < GeneticPathHolder.numberOfPoints(); i++)
        {
            packets.add(null);
        }
    }

    public GeneticPath(ArrayList packets)
    {
        this.packets = packets;
    }
    
    public void generateIndividual()
    {        
        for (int pointIndex = 0; pointIndex < GeneticPathHolder.numberOfPoints(); pointIndex++)
        {
            setPoint(pointIndex, GeneticPathHolder.getPacket(pointIndex));
        }        
        Collections.shuffle(packets);
    }
    
    public Packet getPacketPosition(int pathPosition)
    {
        return (Packet) packets.get(pathPosition);
    }
    
    public void setPoint(int pathPosition, Packet point)
    {
        packets.set(pathPosition, point);
        
        fitness = 0;
        distance = 0;
    }
    
    public double getFitness()
    {
        if (fitness == 0)
        {
            fitness = 1 / (double) getDistance();
        }
        return fitness;
    }

    public int getDistance()
    {
        if (distance == 0)
        {
            int tourDistance = 0;
            for (int cityIndex = 0; cityIndex < pathSize(); cityIndex++)
            {
                Packet fromCity = getPacketPosition(cityIndex);
                Packet destinationPoint;
                
                if (cityIndex + 1 < pathSize())
                {
                    destinationPoint = getPacketPosition(cityIndex + 1);
                }
                else
                {
                    destinationPoint = getPacketPosition(0);
                }
                tourDistance += fromCity.getDistance(destinationPoint);
            }
            distance = tourDistance;
        }
        return distance;
    }

    public int pathSize()
    {
        return packets.size();
    }

    public boolean containsPoint(Packet point)
    {
        return packets.contains(point);
    }

    @Override
    public String toString()
    {
        String geneString = "|";
        for (int i = 0; i < pathSize(); i++)
        {
            geneString += getPacketPosition(i) + "|";
        }
        return geneString;
    }
}
