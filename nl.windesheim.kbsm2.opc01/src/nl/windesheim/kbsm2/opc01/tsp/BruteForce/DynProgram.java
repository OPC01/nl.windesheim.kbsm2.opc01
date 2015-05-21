package nl.windesheim.kbsm2.opc01.tsp.BruteForce;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * @author inspiron
 */
public class DynProgram extends javax.swing.JFrame
{

    Vector<String> elements = new Vector<String>();
    Vector<Double> least = new Vector<Double>();
    Vector<String> path = new Vector<String>();
    double least_value = 0;
    double temp_var = 0;
    String least_path = "";

    /**
     * Creates new form BruteForce
     */
    public DynProgram()
    {
        //initComponents();
        boolean status = true;
        Vector<String> elements = new Vector<String>();
        Vector<Double> least = new Vector<Double>();
        Vector<String> path = new Vector<String>();
        double least_value = 0;
        double temp_var = 0;
        String least_path = "";
        String[][] items = new String[8][8];
    }
        //Object created to handle file loading
    //file = new File("C:\\Users\\Gebruiker\\Documents\\NetBeansProjects\\nl.windesheim.kbsm2.opc01\\Testeriono\\src\\distanceMatrix.txt");
            /*The file is read line by line
     BufferedReader reader = new BufferedReader(new FileReader(file));
     String line;
     int i = 0;
     int k = 1;
     while ((line = reader.readLine()) != null) {
     if (line.trim().length() == 0) {
     break;
     }
     //The various values are being extracted from the comma separation
     StringTokenizer st = new StringTokenizer(line, ",");
     while (st.hasMoreTokens()) {
     //Object to store all values
     elements.add(st.nextToken());
     ++i;
     ++k;
     }
     }
     */

    //Stores the input file values into an array
    public void activate(double[][] map)
    {
        int k = map.length;
        double dist[][] = map;
        System.out.println(Arrays.deepToString(dist));
        Permutator pg = new Permutator(k, 1);
        double sum = 0;
        String g = "";
        String v = "";

//Handles the permutation
        while (pg.hasMore())
        {
            int[] temp = pg.getNext();
            for (int j = 0; j < temp.length; j++)
            {
                g += (temp[j]) + "-";
                v += temp[j] + " ";
            }
            String words[] = g.split("-");
            path.add(v);
            System.out.println(g);
            g = "";
            v = "";
            for (int r = 0; r < words.length - 1; r++)
            {
                //Sums all the values of the permutation
                sum += dist[Integer.parseInt(words[r]) - 1][Integer.parseInt(words[r + 1]) - 1];
            }

            System.out.println(sum);
            least.add(sum);
            //Stores all outcomes
            sum = 0;
            //empties the sum variable to make room for another value
        }

//computes for the least distance
        for (int w = 0; w < least.size(); w++)
        {
            if (w == 0)
            {
                least_value = least.get(w);
                least_path = path.get(w);
            }
            if (least.get(w) < least_value)
            {
                least_value = least.get(w);
                least_path = path.get(w);
            }
        }
        //outputs the file as a text namely result.txt
        try
        {
            FileOutputStream fout = new FileOutputStream(new File("result.txt"));
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jTxtDistance = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("Select File");
        jButton1.setText("Select File");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 273,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTxtDistance, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)
                                .addComponent(jLabel1))
                        .addContainerGap(464, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTxtDistance;
    // End of variables declaration

    public double getLeast_value()
    {
        return least_value;
    }

    public String getLeast_path()
    {
        return least_path;
    }

    public void setLeast_value(double least_value)
    {
        this.least_value = least_value;
    }

    public void setLeast_path(String least_path)
    {
        this.least_path = least_path;
    }

}
