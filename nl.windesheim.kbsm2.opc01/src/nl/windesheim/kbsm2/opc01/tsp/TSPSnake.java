package nl.windesheim.kbsm2.opc01.tsp;

import java.awt.Point;
import java.util.ArrayList;

public class TSPSnake {

    private ArrayList<Packet> path = new ArrayList<>();
    private final ArrayList<Integer> sequence = new ArrayList<>();
    private double lengthOfPath;
    private final ArrayList<Packet> packets;
    private final Point checkboxSizes;

    public TSPSnake(ArrayList<Packet> packets, Point checkboxSizes) {
        this.packets = packets;
        this.checkboxSizes = checkboxSizes;
    }

    public void SnakeAlgorithm() {
        //Gaat van etage naar etage en haalt per etage packet op.
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
