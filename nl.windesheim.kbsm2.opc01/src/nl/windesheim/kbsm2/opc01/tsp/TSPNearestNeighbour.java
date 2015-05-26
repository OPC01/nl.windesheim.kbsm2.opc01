package nl.windesheim.kbsm2.opc01.tsp;

import java.util.*;

public class TSPNearestNeighbour {

    private final Stack<Integer> stack;
    private ArrayList<Packet> pathP;
    private ArrayList<Integer> path;
    private double lengthOfPath;

    public TSPNearestNeighbour() {
        stack = new Stack<>();
    }

    public void tsp(double[][] adjacencyMatrix, ArrayList<Packet> packets) {
        pathP = new ArrayList<>();
        path = new ArrayList<>();
        path.add(0);
        pathP.add(packets.get(0));
        int numberOfNodes = adjacencyMatrix[0].length;
        int[] visited = new int[numberOfNodes];
        visited[0] = 1;
        stack.push(0);
        int element, dst = 0, i;
        double min = Double.MAX_VALUE;
        boolean minFlag = false;
        while (!stack.isEmpty()) {
            element = stack.peek();
            i = 0;
            min = Double.MAX_VALUE;
            while (i < numberOfNodes) {
                if (adjacencyMatrix[element][i] > 0.1 && visited[i] == 0) {
                    // vergelijkt de volgende mogelijke stappen om de kortste route te maken.
                    if (min > adjacencyMatrix[element][i]) {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }

                }
                i++;
            }
            if (minFlag) {
                pathP.add(packets.get(dst));
                path.add(dst);
                visited[dst] = 1;
                stack.push(dst);
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        this.path = path;
        this.pathP = pathP;
        this.calculatePathLength(adjacencyMatrix);
    }

    public double getLengthOfPath() {
        return lengthOfPath;
    }


    public void calculatePathLength(double[][] adjMatrix) {
        double length = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            length = length + pathP.get(i).getDistance(pathP.get(i + 1));
        }
        this.lengthOfPath = length;
    }

}
