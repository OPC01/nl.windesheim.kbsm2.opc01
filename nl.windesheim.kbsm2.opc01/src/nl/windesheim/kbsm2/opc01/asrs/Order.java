package nl.windesheim.kbsm2.opc01.asrs;

import java.util.ArrayList;

public class Order {
	private int ordernummer;
	private Klant klant;
	private ArrayList<Integer> productIDs;
	
	public Order(int ordernummer,Klant klant,ArrayList<Integer> productIDs){
		this.ordernummer = ordernummer;
		this.klant = klant;
		this.productIDs = productIDs;
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
	public ArrayList<Integer> getproductIDs() {
		return productIDs;
	}
	public void setproductIDs(ArrayList<Integer> productIDs) {
		this.productIDs = productIDs;
	}
	@Override
	public String toString() {
		return "Order [ordernummer=" + ordernummer + ", klant=" + klant + ", productIDs=" + productIDs + "]";
	}

}
