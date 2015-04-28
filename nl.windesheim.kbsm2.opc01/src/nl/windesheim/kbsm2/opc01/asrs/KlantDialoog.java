/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.windesheim.kbsm2.opc01.asrs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
/**
 *
 * @author Rob
 */
public class KlantDialoog extends JDialog implements ActionListener {
       
    private JTextField jtfNaam,jtfAchternaam,jtfAdres,jtfPostcode,jtfPlaats;
    private JButton jbToevoegen;
    private JLabel jlKlant;
    
    public KlantDialoog(JFrame frame){
        super(frame, true);
        this.setSize(200,800);
        this.setLayout(null);
        this.setTitle("klantgegevens invoeren");
        
        this.jlKlant = new JLabel("Klant:");
        this.jlKlant.setBounds(50,20,100,20);
        
        this.jtfAchternaam = new JTextField("achternaam");
        this.jtfAchternaam.setBounds(50,60,100,20);
        
        this.jtfAdres = new JTextField("adres");
        this.jtfAdres.setBounds(50, 130, 100, 20);
        
        this.jtfNaam = new JTextField("naam");
        this.jtfNaam.setBounds(50,200,100,20);
        
        this.jtfPlaats = new JTextField("plaats");
        this.jtfPlaats.setBounds(50, 270, 100, 20);
        
        this.jtfPostcode = new JTextField("postcode");
        this.jtfPostcode.setBounds(50,340,100,20);
        
        this.jbToevoegen = new JButton("Toevoegen");
        this.jbToevoegen.setBounds(50, 410, 100, 20);
        
        add(this.jlKlant);
        add(this.jtfNaam);
        add(this.jtfAchternaam);
        add(this.jtfAdres);
        add(this.jtfPostcode);
        add(this.jtfPlaats);
        add(this.jbToevoegen);
                   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
