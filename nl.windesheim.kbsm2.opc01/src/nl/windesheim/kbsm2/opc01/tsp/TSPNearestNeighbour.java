/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.windesheim.kbsm2.opc01.tsp;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Gebruiker
 */
public class TSPNearestNeighbour
{

    private int numberOfNodes;
    private Stack<Integer> stack;
    private ArrayList<Integer> path;

    public TSPNearestNeighbour()
    {

    }

    public void tsp(double adjacencyMatrix[][])
    {
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(1);
        Stack<Integer> stack = new Stack<Integer>();
        int numberOfNodes = adjacencyMatrix[1].length - 1;
        int[] visited = new int[numberOfNodes + 1];
        visited[1] = 1;
        stack.push(1);
        int element, dst = 0, i;
        double min = Double.MAX_VALUE;
        boolean minFlag = false;
        System.out.print(1 + "\t");

        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = 1;
            min = Double.MAX_VALUE;
            while (i <= numberOfNodes)
            {
                if (adjacencyMatrix[element][i] > 1 && visited[i] == 0)
                {
                    if (min > adjacencyMatrix[element][i])
                    {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag)
            {
                path.add(dst);
                visited[dst] = 1;
                stack.push(dst);
                System.out.print(dst + "\t");
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        /**
         * *this.path = path; double routelength = 0; int originPacketCounter;
         * int destinationPacketCounter; for (destinationPacketCounter = 1;
         * destinationPacketCounter < path.size(); destinationPacketCounter++) {
         * originPacketCounter = destinationPacketCounter - 1; int originPacket
         * = path.get(originPacketCounter); int destinationPacket =
         * path.get(destinationPacketCounter); routelength = routelength +
         * adjacencyMatrix[originPacket][destinationPacket];
         *
         * }
         * System.out.println(routelength);
         */

    }
}
