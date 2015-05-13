package nl.windesheim.kbsm2.opc01.asrs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;

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
                "root");
		
		
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

}