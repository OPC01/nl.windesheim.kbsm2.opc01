package nl.windesheim.kbsm2.opc01.tsp;

import java.awt.Point;
import java.util.ArrayList;

public class Packet extends Point
{

    private boolean getPacket;
    private boolean packetAcquired;

    public Packet(int x, int y)
    {
        super(x, y);
        getPacket = false;
        packetAcquired = false;
    }

    public boolean getGetPacket()
    {
        return getPacket;
    }

    public void setGetPacket(boolean getPacket)
    {
        this.getPacket = getPacket;
    }

    public boolean getPacketAcquired()
    {
        return packetAcquired;
    }

    public void setPacketAcquired(boolean packetAcquired)
    {
        this.packetAcquired = packetAcquired;
    }

    public double getDistance(Point that)
    {
        return this.distance(that);
    }

}
