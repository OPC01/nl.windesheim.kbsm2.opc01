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
                Integer justRemoved = notInRoute.remove(0);
                ArrayList<Integer> newRoute = (ArrayList<Integer>) routes.clone();
                newRoute.add(justRemoved);

                bruteForce(newRoute, notInRoute);
                notInRoute.add(justRemoved);
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

    private boolean isBestRoute(ArrayList<Integer> r)
    {
        System.out.println(r.toString());
        return false;
    }

    public void activateBruteForce()
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
//TSPBruteForce.bruteForce(route, lst);