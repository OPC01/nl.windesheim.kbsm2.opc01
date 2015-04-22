package nl.windesheim.kbsm2.opc01.tsp;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MainScreen extends JFrame implements ActionListener
{

    private JRadioButton neighbour;
    private JRadioButton bruteforce;
    private JRadioButton genetic;
    private JButton settings;
    private JButton start;

    private ArrayList<Packet> selectedPackets;
    private int adjacencyMatrix[][];

    public MainScreen()
    {
        setVisible(true);
        setSize(800, 800);
        setTitle("TSP Simulator");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        neighbour = new JRadioButton("Nearest Nieghbour");
        bruteforce = new JRadioButton("Bruteforce");
        genetic = new JRadioButton("Genetic");
        settings = new JButton("Instellingen");
        start = new JButton("Start Simulatie");

        settings.addActionListener(this);
        start.addActionListener(this);
        add(neighbour);
        add(bruteforce);
        add(genetic);
        add(settings);
        add(start);
    }

    public void getSelectedPackets()
    {

    }

    public void createAdjecencyMatrix()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == settings)
        {
            Options instellingen = new Options(this);
            instellingen.setVisible(true);
        }
        if (e.getSource() == start)
        {

        }
    }
}
