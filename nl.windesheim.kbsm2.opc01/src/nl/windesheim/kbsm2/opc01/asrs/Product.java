package nl.windesheim.kbsm2.opc01.asrs;

public class Product {
	int locatieX,locatieY,id,grootte;
	String naam;
	
	public Product(String naam,int locatieX,int locatieY,int grootte,int id){
		this.naam = naam;
		this.locatieX = locatieX;
		this.locatieY = locatieY;
		this.grootte = grootte;
		this.id = id;
	}

	public int getLocatieX() {
		return locatieX;
	}

	public void setLocatieX(int locatieX) {
		this.locatieX = locatieX;
	}

	public int getLocatieY() {
		return locatieY;
	}

	public void setLocatieY(int locatieY) {
		this.locatieY = locatieY;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrootte() {
		return grootte;
	}

	public void setGrootte(int grootte) {
		this.grootte = grootte;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	@Override
	public String toString() {
		return "Product [locatieX=" + locatieX + ", locatieY=" + locatieY
				+ ", id=" + id + ", grootte=" + grootte + ", naam=" + naam
				+ "]";
	}

}
