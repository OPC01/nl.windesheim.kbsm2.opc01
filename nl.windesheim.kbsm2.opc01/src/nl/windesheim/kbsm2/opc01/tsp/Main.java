package nl.windesheim.kbsm2.opc01.tsp;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;

public class Main
{

    public static void main(String[] args)
    {
        DistanceMap z = new DistanceMap();
        Packet a = new Packet(10, 20);
        Packet b = new Packet(5, 30);
        Packet c = new Packet(10, 30);
        Packet d = new Packet(20, 30);
        Packet e = new Packet(1, 30);
        ArrayList<Packet> list = new ArrayList();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        z.createMatrix(list);
        System.out.println(Arrays.deepToString(z.getMap()));
        System.out.println(a.distance(b));
    }
}
