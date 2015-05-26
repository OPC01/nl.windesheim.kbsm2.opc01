package nl.windesheim.kbsm2.opc01.tsp;

import java.awt.*;
import static java.awt.Color.*;
import javax.swing.JPanel;

public class Draw extends JPanel
{
    private Visualisatie v;
    private int hoogte = 30;
    private int breedte = 30;
    
    public Draw(Visualisatie v)
    {
        this.v=v;
        //this.setPreferredSize(new Dimension(300,250));
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(white);
        g.drawRect(20, 20, breedte, hoogte);
    }
}
