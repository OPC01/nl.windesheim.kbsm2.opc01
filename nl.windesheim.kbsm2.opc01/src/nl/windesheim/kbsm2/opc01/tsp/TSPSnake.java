package nl.windesheim.kbsm2.opc01.tsp;

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

    public TSPSnake(double[][] adjMatrix, ArrayList<Packet> packets, Point checkboxSizes) {
        this.adjMatrix = adjMatrix;
        this.packets = packets;
        this.checkboxSizes = checkboxSizes;
    }

    public void SnakeAlgorithm() {
    
    }

}
