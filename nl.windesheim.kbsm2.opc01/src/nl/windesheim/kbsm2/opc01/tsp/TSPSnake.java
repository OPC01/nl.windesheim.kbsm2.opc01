package nl.windesheim.kbsm2.opc01.tsp;

import java.awt.Checkbox;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

public class TSPSnake {

    private ArrayList<Packet> path = new ArrayList<Packet>();
    private ArrayList<Integer> sequence = new ArrayList<Integer>();
    private double lengthOfPath;
    private ArrayList<Packet> packets;
    private Point checkboxSizes;

    public TSPSnake(ArrayList<Packet> packets, Point checkboxSizes) {
        this.packets = packets;
        this.checkboxSizes = checkboxSizes;
    }

    public void SnakeAlgorithm() {
        System.out.println("Y =" + checkboxSizes.getY() + "x= " + checkboxSizes.getX());
        for (int y = 0; y < checkboxSizes.getY() + 1; y++) {
            for (int x = 0; x < checkboxSizes.getX() + 1; x++) {
                for (Packet p : packets) {
                    if (p.getX() == x && p.getY() == y) {
                        path.add(p);
                        sequence.add(packets.indexOf(p));
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

    public void calculatePathLength(double adjMatrix[][]) {
        double length = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            length = length + adjMatrix[sequence.get(i)][sequence.get(i + 1)];
        }
        this.lengthOfPath = length;
    }

}
