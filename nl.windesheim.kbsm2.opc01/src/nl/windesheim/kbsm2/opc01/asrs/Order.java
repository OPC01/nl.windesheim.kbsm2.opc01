package nl.windesheim.kbsm2.opc01.asrs;

import java.util.ArrayList;

public class Order {
	private int ordernummer;
	private String datum;
	private Klant klant;
	private ArrayList<Integer> artikelNRs;
	
	public Order(int ordernummer,Klant klant,String datum,ArrayList<Integer> artikelNRs){
		this.ordernummer = ordernummer;
		this.datum = datum;
		this.klant = klant;
		this.artikelNRs = artikelNRs;
	}
	public int getOrdernummer() {
		return ordernummer;
	}
	public void setOrdernummer(int ordernummer) {
		this.ordernummer = ordernummer;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
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
	@Override
	public String toString() {
		return "Order [ordernummer=" + ordernummer + ", datum=" + datum
				+ ", klant=" + klant + ", artikelNRs=" + artikelNRs + "]";
	}

}
