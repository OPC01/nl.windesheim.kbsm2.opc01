package nl.windesheim.kbsm2.opc01.tsp;

import java.util.*;

public class TSPBruteForce
{
    private ArrayList<Integer> bestPath;

    public void bruteForce(ArrayList<Integer> path, ArrayList<Integer> notInPath)
    {
        if (!notInPath.isEmpty())
        {
            for (int i = 0; i < notInPath.size(); i++)
            {
                Integer removed = notInPath.remove(0);
                ArrayList<Integer> newPath = (ArrayList<Integer>) path.clone();
                newPath.add(removed);

                bruteForce(newPath, notInPath);
                notInPath.add(removed);
            }
        }
        else
        {
            if (isBestPath(path))
            {
                bestPath = path;
            }
        }

    }

    private boolean isBestPath(ArrayList<Integer> path)
    {
        System.out.println(path.toString());
        return false;
    }

    public void activateBruteForce()
    {
        ArrayList<Integer> first = new ArrayList<Integer>();
        for (int i = 0; i < 6; ++i)
        {
            first.add(i);
        }
        ArrayList<Integer> route = new ArrayList<Integer>();
        bruteForce(route, first);
    }
}
//TSPBruteForce.bruteForce(route, first);