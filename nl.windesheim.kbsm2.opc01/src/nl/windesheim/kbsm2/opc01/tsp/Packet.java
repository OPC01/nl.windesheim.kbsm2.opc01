package nl.windesheim.kbsm2.opc01.tsp;

import java.awt.Point;

public class Packet extends Point
{



    public Packet(int x, int y)
    {
        super(x, y);
    }

    // aangepaste versie om distance te berekenen.
    public double getDistance(Point that)
    {
        return this.distance(that);
    }

}
