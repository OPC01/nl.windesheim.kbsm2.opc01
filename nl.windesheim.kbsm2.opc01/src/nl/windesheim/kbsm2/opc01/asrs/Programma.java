package nl.windesheim.kbsm2.opc01.asrs;

import java.sql.SQLException;

public class Programma {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            DatabaseCon test = new DatabaseCon();
            test.connectDatabase("root", "admin");
    }

}