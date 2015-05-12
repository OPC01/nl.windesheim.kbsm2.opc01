package nl.windesheim.kbsm2.opc01.asrs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseCon {
	
	public DatabaseCon(){
		
	}
	
	public void connectDatabase(String username, String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	    Connection con = DriverManager.getConnection(
	                         "jdbc:mysql://localhost/kbsproject",
	                         username,
	                         password);

	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("SELECT * FROM klant");

	    while (rs.next()) {
//	        int x = rs.getInt("leeftijd");
                String naam = rs.getString("voornaam");
                String achternaam = rs.getString("achternaam");
                String adres = rs.getString("adres");
//	        String s = rs.getString("naam");
                
                System.out.println("Naam: "+naam+"  Achternaam: "+achternaam+"  Adres: "+adres);
	    }
	}

}