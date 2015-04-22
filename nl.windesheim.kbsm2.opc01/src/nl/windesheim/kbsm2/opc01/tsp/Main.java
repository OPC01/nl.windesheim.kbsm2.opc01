package nl.windesheim.kbsm2.opc01.tsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import javax.swing.JFrame;

public class Main
{

    public static void main(String[] args)
    {
        DistanceMap z = new DistanceMap();
        Packet f = new Packet(0, 0);
        Packet a = new Packet(10, 0);
        Packet b = new Packet(20, 0);
        Packet c = new Packet(30, 0);
        Packet d = new Packet(0, 5);
        //Packet e = new Packet(1, 30);
        ArrayList<Packet> list = new ArrayList<Packet>();
        list.add(f);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        //zlist.add(e);
        z.createMatrix(list);
        TSPNearestNeighbour x = new TSPNearestNeighbour();
        x.tsp(z.getMap());
        System.out.println(Arrays.deepToString(z.getMap()));
    }
}
