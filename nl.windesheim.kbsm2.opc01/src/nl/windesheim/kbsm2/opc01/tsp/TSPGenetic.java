package nl.windesheim.kbsm2.opc01.tsp;

public class TSPGenetic
{
    public static void main(String[] args)
    {
        // Initialize population
         GeneticPoints pop = new GeneticPoints(50, true);
         System.out.println("Initial distance: " + pop.getFittest().getDistance());

         // Evolve population for 100 generations
         pop = GeneticAlgorithm.evolvePopulation(pop);
         for (int i = 0; i < 100; i++)
         {
         pop = GeneticAlgorithm.evolvePopulation(pop);
         }

         // Print final results
         System.out.println("Finished");
         System.out.println("Final distance: " + pop.getFittest().getDistance());
         System.out.println("Solution:");
         System.out.println(pop.getFittest());
    }
}
