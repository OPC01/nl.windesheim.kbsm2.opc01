package nl.windesheim.kbsm2.opc01.asrs;

public class Klant {
	private String voornaam,achternaam,adres,postcode,plaats;
	
	@Override
	public String toString() {
		return "Klant [voornaam=" + voornaam + ", achternaam=" + achternaam
				+ ", adres=" + adres + ", postcode=" + postcode + ", plaats="
				+ plaats + "]";
	}

	public Klant(String voornaam, String achternaam, String adres,String  postcode,String plaats){
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.adres = adres;
		this.postcode = postcode;
		this.plaats = plaats;		
	}
	
	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPlaats() {
		return plaats;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

}
