package nl.windesheim.kbsm2.opc01.asrs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Order {
	private int ordernummer;
	private Klant klant;
	private ArrayList<Integer> artikelNRs;
	DatabaseCon con;
	
	public Order(int ordernummer,Klant klant,ArrayList<Integer> artikelNRs){
		this.ordernummer = ordernummer;
		this.klant = klant;
		this.artikelNRs = artikelNRs;
	}
	public Order(int ordernummer){
		this.ordernummer = ordernummer;
	}
	public int getOrdernummer() {
		return ordernummer;
	}
	public void setOrdernummer(int ordernummer) {
		this.ordernummer = ordernummer;
	}
	public Klant getKlant() {
		return klant;
	}
	public void setKlant(Klant klant) {
		this.klant = klant;
	}
	public ArrayList<Integer> getArtikelNRs() {
		return artikelNRs;
	}
	public void setArtikelNRs(ArrayList<Integer> artikelNRs) {
		this.artikelNRs = artikelNRs;
	}
	@SuppressWarnings("null")
	public ArrayList<Packet> getProducten() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		ArrayList<Packet> producten = null;
		int id = this.getOrdernummer();
		ResultSet rs = con.getOrderById(id);
		while(rs.next()){
			int x = rs.getInt("locatieX"); 
			int y = rs.getInt("locatieY");
			Packet p = new Packet(x,y);
			producten.add(p);
		}
		
		return producten;
		
	}
	
	@Override
	public String toString() {
		return "Order [ordernummer=" + ordernummer + " klant=" + klant + ", artikelNRs=" + artikelNRs + "]";
	}

}
