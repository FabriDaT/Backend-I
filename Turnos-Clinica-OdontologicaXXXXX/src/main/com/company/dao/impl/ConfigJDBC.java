package main.com.company.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigJDBC {

    public Connection getConnection() {
        try {
            String DB_JBC_DRIVER = "org.h2.Driver";
            Class.forName(DB_JBC_DRIVER);

            String DB_URL = "jdbc:h2:D:\\Program Files\\H2\\bin\\BasesDeDatos\\Turnos-Clinica";
            String DB_USER = "admin";
            String DB_PASSWORD = "123";
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
