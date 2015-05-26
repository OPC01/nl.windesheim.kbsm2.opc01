package nl.windesheim.kbsm2.opc01.asrs;

import nl.windesheim.kbsm2.opc01.tsp.*;
import java.awt.Point;
import java.util.ArrayList;

public class Packet extends Point
{

    public Packet(int x, int y)
    {
        super(x, y);

    }

    public double getDistance(Point that)
    {
        return this.distance(that);
    }

}
