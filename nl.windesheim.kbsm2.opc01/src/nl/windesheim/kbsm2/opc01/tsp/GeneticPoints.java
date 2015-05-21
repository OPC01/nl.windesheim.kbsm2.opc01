package nl.windesheim.kbsm2.opc01.tsp;

public class GeneticPoints
{
    GeneticPath[] tours;

    public GeneticPoints(int populationSize, boolean initialise)
    {
        tours = new GeneticPath[populationSize];
        if (initialise)
        {
            for (int i = 0; i < populationSize(); i++)
            {
                GeneticPath newTour = new GeneticPath();
                newTour.generateIndividual();
                saveTour(i, newTour);
            }
        }
    }

    public void saveTour(int index, GeneticPath tour)
    {
        tours[index] = tour;
    }

    public GeneticPath getTour(int index)
    {
        return tours[index];
    }

    public GeneticPath getFittest()
    {
        GeneticPath fittest = tours[0];

        for (int i = 1; i < populationSize(); i++)
        {
            if (fittest.getFitness() <= getTour(i).getFitness())
            {
                fittest = getTour(i);
            }
        }
        return fittest;
    }

    // Gets population size
    public int populationSize()
    {
        return tours.length;
    }
}
