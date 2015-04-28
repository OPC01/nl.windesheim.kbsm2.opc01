package nl.windesheim.kbsm2.opc01.tsp;

public class Path
{

    public int[] order;
    public double length;

    public Path(int numberOfPackets)
    {
        order = new int[numberOfPackets];
    }

    public void copy(Path path)
    {
        for (int i = 0; i < path.order.length; i++)
        {
            order[i] = path.order[i];
        }
        length = path.length;
    }
}
