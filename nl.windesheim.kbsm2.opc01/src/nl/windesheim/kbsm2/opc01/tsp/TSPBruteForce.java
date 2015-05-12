package nl.windesheim.kbsm2.opc01.tsp;

import java.util.*;

public class TSPBruteForce
{
    private ArrayList<Integer> bestRoute;

    public void bruteForce(ArrayList<Integer> routes, ArrayList<Integer> notInRoute)
    {
        if (!notInRoute.isEmpty())
        {
            for (int i = 0; i < notInRoute.size(); i++)
            {
                Integer removed = notInRoute.remove(0);
                ArrayList<Integer> newRoute = (ArrayList<Integer>) routes.clone();
                newRoute.add(removed);

                bruteForce(newRoute, notInRoute);
                notInRoute.add(removed);
            }
        }
        else
        {
            if (isBestRoute(routes))
            {
                bestRoute = routes;
            }
        }

    }

    private boolean isBestRoute(ArrayList<Integer> routes)
    {
        System.out.println(routes.toString());
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