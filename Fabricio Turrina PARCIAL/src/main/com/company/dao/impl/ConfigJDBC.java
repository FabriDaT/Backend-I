package main.com.company.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigJDBC {

    public Connection getConnection() {
        try {
            String DB_JBC_DRIVER = "org.h2.Driver";
            Class.forName(DB_JBC_DRIVER);

            String DB_URL = "jdbc:h2:~/DB_odontologos";
            String DB_USER = "fabri";
            String DB_PASSWORD = "";
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
