package nl.windesheim.kbsm2.opc01.tsp;

import java.awt.Checkbox;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

public class TSPSnake {

    private int numberOfNodes;
    private ArrayList<Packet> path = new ArrayList<Packet>();

    private double lengthOfPath;
    private double[][] adjMatrix;
    private ArrayList<Packet> packets;
    private Point checkboxSizes;

    public TSPSnake(double[][] adjMatrix, ArrayList<Packet> packets, Point checkboxSizes) {
        this.adjMatrix = adjMatrix;
        this.packets = packets;
        this.checkboxSizes = checkboxSizes;
    }

    public void SnakeAlgorithm() {
        System.out.println("Y =" + checkboxSizes.getY() + "x= " + checkboxSizes.getX());
        for (int y = 0; y < checkboxSizes.getY() +1; y++) {
            for (int x = 0; x < checkboxSizes.getX() +1; x++) {
                for (Packet p : packets) {
                    if (p.getX() == x && p.getY() == y) {
                        path.add(p);
                    }
                }
            }
        }
        this.path = path;
    }

    public ArrayList<Packet> getPath() {
        return path;
    }

    public double getLengthOfPath() {
        return lengthOfPath;
    }
    
}
