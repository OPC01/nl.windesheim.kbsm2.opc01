package nl.windesheim.kbsm2.opc01.asrs;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Paneel extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7958972375482775135L;
	final JButton BTStart,BTOrderMaken,BTProducten,BTOrderSelect,BTNieuwProduct;
	private final JLabel JLStatus,JLOrder;
	final static JLabel JLOrderNr = new JLabel();
        final static JButton BTPakbon = new JButton("Pakbon genereren");
	private final JLabel JLLocatie;
	private final JLabel JLLocatieId;
	private final JLabel JLPakketten;
	private final JLabel JLAantalP;
	private final JLabel JLBezig;
	private Teken TekenPaneel;
        
    private JFileChooser fileChooser = new JFileChooser();

	
	public Paneel(){
        this.setSize(1000,600);
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setTitle("AS/RS Systeem");
            
            
		// setLayout(null);
		
		BTStart = new JButton("Start");
		BTStart.setBounds(10, 10, 150, 30);
		
		BTOrderMaken = new JButton("Order inbrengen");
		BTOrderMaken.setBounds(165,10, 150,30);
		
		BTProducten = new JButton("Producten ophalen");
		BTProducten.setBounds(10,50,150,30);
		
		BTOrderSelect = new JButton("Order Selecteren");
		BTOrderSelect.setBounds(165,50,150,30);
		
		BTNieuwProduct = new JButton("Product toevoegen");
		BTNieuwProduct.setBounds(440,500,150,30);
		

        BTPakbon.setEnabled(false);
		BTPakbon.setBounds(600,500,150,30);
		
		JLStatus = new JLabel("Status:");
		JLStatus.setBounds(10,140,100,20);
		
		//JLOrderNr = new JLabel("...");
		JLOrderNr.setBounds(160,160,100,20);
		
		JLOrder = new JLabel("Order Nummer:");
		JLOrder.setBounds(10,160,150,20);
		
		JLLocatie = new JLabel("Locatie arm: ");
		JLLocatie.setBounds(10,180,150,20);
		
		JLLocatieId = new JLabel("...");
		JLLocatieId.setBounds(160,180,100,20);
		
		JLPakketten = new JLabel("Aantal pakketten: ");
		JLPakketten.setBounds(10,200,150,20);
		
		JLAantalP = new JLabel("...");
		JLAantalP.setBounds(160,200,100,20);
		
		JLBezig = new JLabel("Bezig :");
		JLBezig.setBounds(10,220,100,20);
		
		add(BTStart);
		add(BTOrderMaken);
		add(BTProducten);
		add(BTOrderSelect);
		add(BTNieuwProduct);
		add(BTPakbon);
		add(JLStatus);
		add(JLOrderNr);
		add(JLOrder);
		add(JLLocatie);
		add(JLLocatieId);
		add(JLPakketten);
		add(JLAantalP);
		add(JLBezig);
		
		TekenPaneel = new Teken();
		add(TekenPaneel);
		repaint();
		
        this.setVisible(true);
        this.BTStart.addActionListener(this);
        this.BTOrderMaken.addActionListener(this);
        this.BTOrderSelect.addActionListener(this);
        this.BTProducten.addActionListener(this);
        this.BTNieuwProduct.addActionListener(this);
        this.BTPakbon.addActionListener(this);
		
	}

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == BTStart){;
            KlantDialoog d = new KlantDialoog(this);
            d.setVisible(true);
        }
        else if(e.getSource() == BTOrderMaken) {
            int result = fileChooser.showOpenDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Geselecteerd bestand: " + selectedFile.getAbsolutePath());
                try {
					XMLReader.readXML(selectedFile);
				} catch (ParserConfigurationException | IOException
						| SAXException | ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        }
        else if(e.getSource() == BTOrderSelect) {
            OrderlijstDialoog d = null;
			try {
				d = new OrderlijstDialoog(this, true);
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            d.setVisible(true);
        }
        else if(e.getSource() == BTProducten) {
            ProductSelecterenDialoog d;
			try {
				d = new ProductSelecterenDialoog(this, true);
				d.setVisible(true);
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
        }
        else if(e.getSource() == BTNieuwProduct) {
            ProductToevoegenDialoog d = new ProductToevoegenDialoog(this, true);
            d.setVisible(true);
        }
        else if(e.getSource() == BTPakbon) {
            String path = System.getProperty("user.home") + "/Desktop/pakbonnen/";
            File pakbonDir = new File(path);
            
            // als directory 'pakbonnen' niet bestaat, aanmaken
            if( ! pakbonDir.exists()) {
                System.out.println("Map 'pakbonnen' aanmaken");
                pakbonDir.mkdir();
            }
            
            try {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                
                
                int orderNr = Integer.parseInt(JLOrderNr.getText());
                DatabaseCon dbc = new DatabaseCon();
                ResultSet order = dbc.getOrderById(orderNr);
                int klantid = 0;
                ArrayList<Integer> artikels = new ArrayList<>();
                while(order.next()){
                	klantid = order.getInt("klantid");
                	artikels.add(order.getInt("productid"));
                }
                ResultSet klant = dbc.getKlantById(klantid);
                String voorAchternaam=null,adres=null,postcode=null,plaats=null;
               
                while(klant.next()){ 
	                voorAchternaam = klant.getString("voornaam") + " " + klant.getString("achternaam");
	                adres = klant.getString("adres");
	                postcode = klant.getString("postcode");
	                plaats = klant.getString("plaats");   
                }
                String fileName = sdf.format(date) + "_" + orderNr + ".txt";
                
                // tekst bestand aanmaken
                FileWriter fstream = new FileWriter(path + fileName);
                BufferedWriter out = new BufferedWriter(fstream);
                out.write("Datum: " + sdf.format(date) + "\n");
                out.write("Ordernummer: " + orderNr +"\n\n");
                out.write("Naam: " + voorAchternaam + "\n");
                out.write("Adres: " + adres + "\n");
                out.write("Postcode: " + postcode + "\n");
                out.write("Plaats: " + plaats + "\n\n\n");
                for (int i = 0; i < artikels.size(); i++) {
                    out.write("Artikelnummer: " + artikels.get(i) + "\n");
                }
                
                out.close();
            }
            catch(Exception error) {
                System.err.println("Error: " + error.getMessage());
            }
        }
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
