package nl.windesheim.kbsm2.opc01.tsp;

import java.util.*;

public class DistanceMap
{

    double[][] map;

    public DistanceMap()
    {

    }
<<<<<<< HEAD

=======
// creëert een adjacency matrix uit ingevoerde ArrayList van Packets.
    // deze wordt gebruikt in sommige algoritme om de afstand tussen verschillende packets te kunnen bepalen
>>>>>>> ceda59251a85744467df3cf274d267fc660731a5
    public void createMatrix(ArrayList<Packet> packets)
    {
        double[][] map = new double[packets.size()][packets.size()];
        for (int i = 0; i < packets.size(); i++)
        {
            for (int j = 0; j < packets.size(); j++)
            {
                map[i][j] = packets.get(i).distance(packets.get(j));
            }
        }
        for (int i = 0; i < packets.size(); i++)
        {
            for (int j = 0; j < packets.size(); j++)
            {
                if (map[i][j] == 1 && map[j][i] == 0)
                {
                    map[j][i] = 1;
                }
            }
        }
        this.map = map;
    }

    public double[][] getMap()
    {
        return map;
    }

<<<<<<< HEAD
    public void setMap(double[][] map)
    {
        this.map = map;
    }

=======
>>>>>>> ceda59251a85744467df3cf274d267fc660731a5
}
