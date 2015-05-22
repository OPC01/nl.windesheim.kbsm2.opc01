package nl.windesheim.kbsm2.opc01.tsp;

import java.util.*;

public class TSPBruteForce
{
    private static ArrayList<Integer> bestPath;

    public static void bruteForce(ArrayList<Integer> inPath, ArrayList<Integer> notInPath)
    {
        if (!notInPath.isEmpty())
        {
            for (int i = 0; i < notInPath.size(); i++)
            {
                Integer removed = notInPath.remove(0);
                ArrayList<Integer> newPath = (ArrayList<Integer>) inPath.clone();
                newPath.add(removed);

                bruteForce(newPath, notInPath);
                notInPath.add(removed);
            }
        }
        else
        {
            if (isBestPath(inPath))
            {
                bestPath = inPath;
            }
        }

    }

    private static boolean isBestPath(ArrayList<Integer> path)
    {
        return false;
    }

    public static void activateBruteForce()
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
