package nl.windesheim.kbsm2.opc01.tsp;

import java.util.ArrayList;
import java.util.Stack;

public class TSPNearestNeighbour
{

    private int numberOfNodes;
    private Stack<Integer> stack;
    private ArrayList<Integer> path;
    private double lengthOfPath;

    public TSPNearestNeighbour()
    {
        stack = new Stack<Integer>();
    }

    public void tsp(double adjacencyMatrix[][])
    {
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(0);
        int numberOfNodes = adjacencyMatrix[0].length;
        int[] visited = new int[numberOfNodes];
        visited[0] = 1;
        stack.push(0);
        int element, dst = 0, i;
        double min = Double.MAX_VALUE;
        boolean minFlag = false;
        System.out.print("0" + "\t");
        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = 0;
            min = Double.MAX_VALUE;
            while (i < numberOfNodes)
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

        this.path = path;
    }

    public int getNumberOfNodes()
    {
        return numberOfNodes;
    }

    public void setNumberOfNodes(int numberOfNodes)
    {
        this.numberOfNodes = numberOfNodes;
    }

    public Stack<Integer> getStack()
    {
        return stack;
    }

    public void setStack(Stack<Integer> stack)
    {
        this.stack = stack;
    }

    public ArrayList<Integer> getPath()
    {
        return path;
    }

    public void setPath(ArrayList<Integer> path)
    {
        this.path = path;
    }

    public double getLengthOfPath()
    {
        return lengthOfPath;
    }

    public void setLengthOfPath(double lengthOfPath)
    {
        this.lengthOfPath = lengthOfPath;
    }

    public void calculatePathLength(double adjMatrix[][], ArrayList<Packet> packets)
    {
        double length = 0;
        for (int i = 0; i < path.size() - 1; i++)
        {
            length = length + adjMatrix[path.get(i)][path.get(i + 1)];
        }
        this.lengthOfPath = length;
    }

}
