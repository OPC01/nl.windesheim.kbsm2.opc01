package nl.windesheim.kbsm2.opc01.asrs;

import java.awt.Point;
import java.util.*;

public class TSPNearestNeighbourASRS {

    private Stack<Integer> stack;

    public TSPNearestNeighbourASRS() {
        stack = new Stack<Integer>();
    }

    public ArrayList<Packet> tsp(double[][] adjacencyMatrix, ArrayList<Packet> packets) {
        ArrayList<Packet> path = new ArrayList<Packet>();
        path.add(packets.get(0));
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
                    if (min > adjacencyMatrix[element][i]) {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }

                }
                i++;
            }
            if (minFlag) {
                path.add(packets.get(dst));
                visited[dst] = 1;
                stack.push(dst);
                minFlag = false;
                continue;
            }
            stack.pop();
        }

        return path;
    }

    class DistanceMap {

        double[][] map;

        public DistanceMap() {

        }

        public double[][] createMatrix(ArrayList<Packet> packets) {
            double[][] map = new double[packets.size()][packets.size()];
            for (int i = 0; i < packets.size(); i++) {
                for (int j = 0; j < packets.size(); j++) {
                    map[i][j] = packets.get(i).distance(packets.get(j));
                }
            }
            for (int i = 0; i < packets.size(); i++) {
                for (int j = 0; j < packets.size(); j++) {
                    if (map[i][j] == 1 && map[j][i] == 0) {
                        map[j][i] = 1;
                    }
                }
            }
            return map;
        }


    }
}
