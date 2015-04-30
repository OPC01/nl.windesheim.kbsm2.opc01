package nl.windesheim.kbsm2.opc01.tsp;

import java.util.*;

public class TSPBruteForce
{
    private static ArrayList<Integer> bestRoute;

    public static void bruteForce(ArrayList<Integer> r, ArrayList<Integer> citiesNotInRoute)
    {
        if (!citiesNotInRoute.isEmpty())
        {
            for (int i = 0; i < citiesNotInRoute.size(); i++)
            {
                Integer justRemoved = citiesNotInRoute.remove(0);
                ArrayList<Integer> newRoute = (ArrayList<Integer>) r.clone();
                newRoute.add(justRemoved);

                bruteForce(newRoute, citiesNotInRoute);
                citiesNotInRoute.add(justRemoved);
            }
        }
        else
        {
            if (isBestRoute(r))
            {
                bestRoute = r;
            }
        }

    }

    private static boolean isBestRoute(ArrayList<Integer> r)
    {
        System.out.println(r.toString());
        return false;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for (int i = 0; i < 6; ++i)
        {
            lst.add(i);
        }
        ArrayList<Integer> route = new ArrayList<Integer>();
        bruteForce(route, lst);
    }
}
