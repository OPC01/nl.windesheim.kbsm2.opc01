package nl.windesheim.kbsm2.opc01.asrs;

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paneel extends JFrame implements ActionListener{
	private final JButton BTKlantengegevens,BTOrderMaken,BTProducten,BTOrderSelect,BTNieuwProduct,BTPakbon;
	private final JLabel JLStatus;
	
	public Paneel(){
                this.setSize(1000,600);
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setTitle("AS/RS Systeem");
            
            
		setLayout(null);
		
		BTKlantengegevens = new JButton("Klanten gegevens");
		BTKlantengegevens.setBounds(10, 10, 150, 30);
		
		BTOrderMaken = new JButton("Order aanmaken");
		BTOrderMaken.setBounds(165,10, 150,30);
		
		BTProducten = new JButton("Producten ophalen");
		BTProducten.setBounds(10,50,150,30);
		
		BTOrderSelect = new JButton("Order Selecteren");
		BTOrderSelect.setBounds(165,50,150,30);
		
		BTNieuwProduct = new JButton("Product toevoegen");
		BTNieuwProduct.setBounds(440,500,150,30);
		
		BTPakbon = new JButton("Pakbon genereren");
		BTPakbon.setBounds(600,500,150,30);
		
		JLStatus = new JLabel("Status:");
		JLStatus.setBounds(10,140,100,20);
		
		add(BTKlantengegevens);
		add(BTOrderMaken);
		add(BTProducten);
		add(BTOrderSelect);
		add(BTNieuwProduct);
		add(BTPakbon);
		add(JLStatus);
                this.setVisible(true);
                this.BTKlantengegevens.addActionListener(this);
		
	}
	/*
	public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawRect(420, 10, 500, 450);
		g.drawRect(10,180,300,300);
	  }
        */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == BTKlantengegevens){;
            KlantDialoog d = new KlantDialoog(this);
            d.setVisible(true);
        
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}