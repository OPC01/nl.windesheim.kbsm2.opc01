package nl.windesheim.kbsm2.opc01.tsp;

public class GeneticAlgorithm
{
    private static double mutationRate = 0.015;
    private static int tournamentSize = 5;
    private static boolean elitism = true;

    public static GeneticPoints evolvePopulation(GeneticPoints pop)
    {
        GeneticPoints newPopulation = new GeneticPoints(pop.populationSize(), false);

        int elitismOffset = 0;
        if (elitism)
        {
            newPopulation.saveTour(0, pop.getFittest());
            elitismOffset = 1;
        }

        for (int i = elitismOffset; i < newPopulation.populationSize(); i++)
        {
            GeneticPath parent1 = tournamentSelection(pop);
            GeneticPath parent2 = tournamentSelection(pop);
            
            GeneticPath child = crossover(parent1, parent2);

            newPopulation.saveTour(i, child);
        }

        for (int i = elitismOffset; i < newPopulation.populationSize(); i++)
        {
            mutate(newPopulation.getTour(i));
        }

        return newPopulation;
    }

    public static GeneticPath crossover(GeneticPath parent1, GeneticPath parent2)
    {
        GeneticPath child = new GeneticPath();

        int startPos = (int) (Math.random() * parent1.pathSize());
        int endPos = (int) (Math.random() * parent1.pathSize());

        for (int i = 0; i < child.pathSize(); i++)
        {
            if (startPos < endPos && i > startPos && i < endPos)
            {
                child.setPoint(i, parent1.getPacketPosition(i));
            }
            else if (startPos > endPos)
            {
                if (!(i < startPos && i > endPos))
                {
                    child.setPoint(i, parent1.getPacketPosition(i));
                }
            }
        }

        for (int i = 0; i < parent2.pathSize(); i++)
        {
            if (!child.containsPoint(parent2.getPacketPosition(i)))
            {
                for (int ii = 0; ii < child.pathSize(); ii++)
                {
                    if (child.getPacketPosition(ii) == null)
                    {
                        child.setPoint(ii, parent2.getPacketPosition(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    private static void mutate(GeneticPath tour)
    {
        for (int tourPos1 = 0; tourPos1 < tour.pathSize(); tourPos1++)
        {
            if (Math.random() < mutationRate)
            {
                int tourPos2 = (int) (tour.pathSize() * Math.random());

                Packet city1 = tour.getPacketPosition(tourPos1);
                Packet city2 = tour.getPacketPosition(tourPos2);

                tour.setPoint(tourPos2, city1);
                tour.setPoint(tourPos1, city2);
            }
        }
    }

    private static GeneticPath tournamentSelection(GeneticPoints pop)
    {
        GeneticPoints tournament = new GeneticPoints(tournamentSize, false);
        for (int i = 0; i < tournamentSize; i++)
        {
            int randomId = (int) (Math.random() * pop.populationSize());
            tournament.saveTour(i, pop.getTour(randomId));
        }

        GeneticPath fittest = tournament.getFittest();
        return fittest;
    }
}
