package nl.windesheim.kbsm2.opc01.tsp;

import java.awt.Point;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> ceda59251a85744467df3cf274d267fc660731a5

public class Packet extends Point
{

<<<<<<< HEAD
    private boolean getPacket;
    private boolean packetAcquired;
=======

>>>>>>> ceda59251a85744467df3cf274d267fc660731a5

    public Packet(int x, int y)
    {
        super(x, y);
<<<<<<< HEAD
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

=======
    }

    // aangepaste versie om distance te berekenen.
>>>>>>> ceda59251a85744467df3cf274d267fc660731a5
    public double getDistance(Point that)
    {
        return this.distance(that);
    }

}
