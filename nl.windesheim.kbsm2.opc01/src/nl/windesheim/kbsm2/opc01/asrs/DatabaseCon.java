package nl.windesheim.kbsm2.opc01.asrs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseCon {
	
	public DatabaseCon(){
		
	}
	
	public void connectDatabase() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

	}
	
	public Connection con() throws SQLException{
	    Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/kbsproject",
                "root",
                "admin");
		
		
		return con;
	}
	
    
    public ResultSet getOrders() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        DatabaseCon db = new DatabaseCon();
        db.connectDatabase();
        Connection con = db.con();
        
        
    	Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT * FROM `order`");
    	return rs;
    } 
    public ResultSet getOrderById(int i) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        DatabaseCon db = new DatabaseCon();
        db.connectDatabase();
        Connection con = db.con();
        
        
    	Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT * FROM `order` WHERE orderid="+i);
    	
    	return rs;
    }
    
    public ResultSet getKlanten() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        DatabaseCon db = new DatabaseCon();
        db.connectDatabase();
        Connection con = db.con();
        
        
    	Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT * FROM `klant`");
    	
    	return rs;
    }
    
    public ResultSet getKlantById(int i) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        DatabaseCon db = new DatabaseCon();
        db.connectDatabase();
        Connection con = db.con();
        
        
    	Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT * FROM `klant` WHERE klantid="+i);
    	
    	return rs;
    	
    }
    
    public ResultSet getProducten() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        DatabaseCon db = new DatabaseCon();
        db.connectDatabase();
        Connection con = db.con();
        
        
    	Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT * FROM `product`");
    	
    	return rs;
    	
    }
    
    public ResultSet getProductById(int i) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        DatabaseCon db = new DatabaseCon();
        db.connectDatabase();
        Connection con = db.con();
        
        
    	Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT * FROM `product` WHERE productid="+i);
    	
    	return rs;
    	
    }
    
    public void addProduct(int size,String name,int x, int y) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
    	DatabaseCon db = new DatabaseCon();
        db.connectDatabase();
        Connection con = db.con();
    	
		java.sql.PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO product"+" (naam,grootte,locatieX,LocatieY) VALUES "+" (?,?,?,?)";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, size);
		preparedStatement.setInt(3, x);
		preparedStatement.setInt(4, y);
		preparedStatement.executeUpdate();
    }
    
    public void InsertOrder(Klant klant,ArrayList<Integer> productid,int ordernr) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
    	String voornaam,achternaam,adres,postcode,plaats;
    	achternaam = klant.getAchternaam();
    	voornaam = klant.getVoornaam();
    	adres = klant.getAdres();
    	postcode = klant.getPostcode();
    	plaats = klant.getPlaats();   	
    	
    	DatabaseCon db = new DatabaseCon();
        db.connectDatabase();
        Connection con = db.con();
        
        java.sql.PreparedStatement stmt = null;
        String sql = "SELECT count(*) AS counter FROM klant WHERE voornaam= ? AND achternaam= ? AND postcode= ? AND plaats= ? AND adres= ?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, voornaam);
        stmt.setString(2, achternaam);
        stmt.setString(3, postcode);
        stmt.setString(4, plaats);
        stmt.setString(5, adres);
    	ResultSet rs = stmt.executeQuery();
    	
    	rs.next();
    	int rows = rs.getInt("counter");
    	int klantid;
    	if(rows > 0){
    		sql = "SELECT klantid FROM klant WHERE voornaam= ? AND achternaam= ? AND postcode= ? AND plaats= ? AND adres= ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, voornaam);
            stmt.setString(2, achternaam);
            stmt.setString(3, postcode);
            stmt.setString(4, plaats);
            stmt.setString(5, adres);
        	rs = stmt.executeQuery();
        	rs.next();
        	klantid = rs.getInt("klantid");
        	//voor testen
        	System.out.println(klantid);
        	//
    	}
    	else{
    		java.sql.PreparedStatement preparedStatement = null;
    		sql = "INSERT INTO klant"+" (voornaam,achternaam,adres,postcode,plaats) VALUES "+" (?,?,?,?,?)";
    		preparedStatement = con.prepareStatement(sql);
    		preparedStatement.setString(1, voornaam);
    		preparedStatement.setString(2, achternaam);
    		preparedStatement.setString(3, adres);
    		preparedStatement.setString(4, postcode);
    		preparedStatement.setString(5, plaats);
    		int i = preparedStatement.executeUpdate();
    		//voor testen
    		System.out.println(Integer.toString(i));
    		//
    		sql = "SELECT klantid FROM klant ORDER BY klantid DESC LIMIT 1";
    		ResultSet resultSet = stmt.executeQuery(sql);
    		
    		resultSet.next();
    		klantid = resultSet.getInt("klantid");
    		//voor testen
    		System.out.println(klantid);
    		//
    	}
    	
    	java.sql.PreparedStatement preparedStatement = null;
    	
    	for(int i = 0; i < productid.size(); i++){
    		int product = productid.get(i);
			sql = "INSERT INTO `order` "+" (klantid,productid,ordernr) VALUES "+" (?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, klantid);
			preparedStatement.setInt(2, product);
			preparedStatement.setInt(3, ordernr);
			preparedStatement.executeUpdate();
    	}
    	
    	
    }

}
