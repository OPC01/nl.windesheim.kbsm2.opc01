package nl.windesheim.kbsm2.opc01.tsp;

import java.awt.Checkbox;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

public class TSPSnake {

    private int numberOfNodes;
    private ArrayList<Integer> path = new ArrayList<Integer>();

    private double lengthOfPath;
    private double[][] adjMatrix;
    private ArrayList<Packet> packets;
    private Point checkboxSizes;
    ArrayList<Packet> allPackets;

    public TSPSnake(double[][] adjMatrix, ArrayList<Packet> packets, Point checkboxSizes, ArrayList<Packet> allPackets) {
        this.adjMatrix = adjMatrix;
        this.packets = packets;
        this.checkboxSizes = checkboxSizes;
        this.allPackets = allPackets;
    }

    public void SnakeAlgorithm() {
        for (int y = 0; y < checkboxSizes.getY(); y++) {
            for (int x = 0; x < checkboxSizes.getX(); x++) {
                for (Packet p : packets) {
                    if (p.getX() == x && p.getY() == y) {
                        path.add(packets.indexOf(p));
                    }
                }
            }
        }
        for(Integer I: path){
            System.out.println(I + " ");
        }
    }
}
