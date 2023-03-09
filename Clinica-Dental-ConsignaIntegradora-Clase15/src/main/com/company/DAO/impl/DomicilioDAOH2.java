package main.com.company.DAO.impl;

import main.com.company.DAO.IDao;
import main.com.company.model.Domicilio;

import java.sql.*;
import java.util.logging.Logger;

public class DomicilioDAOH2 implements IDao<Domicilio> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/DB_Pacientes;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER = "fabri";
    private final static String DB_PASSWORD = "";
    private final static String DB_SQL_CREATE = "CREATE DATABASE IF NOT EXISTS ClinicaDental;" +

            "USE ClinicaDental; " +
            "create table IF NOT EXISTS CREATE TABLE DOMICILIO (\n" +
            "  id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "  calle VARCHAR(50) NOT NULL,\n" +
            "  numero INT NOT NULL,\n" +
            "  localidad VARCHAR(50) NOT NULL,\n" +
            "  provincia VARCHAR(50) NOT NULL\n" +
            ");";

    private static final Logger logger = Logger.getLogger(String.valueOf(DomicilioDAOH2.class));

    public static Connection con() {
        Connection c = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
             e.printStackTrace();
        }
        return  c;
    }

    @Override
    public Domicilio leer(int id) {
        return null;
    }

    @Override
    public Domicilio guardar(Domicilio unDomicilio) {
        Connection coneccion = con();
        PreparedStatement ps = coneccion.prepareStatement("INSERT INTO DOMICILIOS(calle, numero, localidad, provincia) VALUES" +
                "(?, ?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,unDomicilio.getCalle());
        ps.setInt(2,unDomicilio.getNumero());
        ps.setString(3,unDomicilio.getLocalidad();
        ps.setString(4,unDomicilio.getProvincia();

        ps.executeUpdate();

        ResultSet keys = ps.getGeneratedKeys();
        while(keys.next()){
            unDomicilio.setId(keys.getInt(1));
        }

        ps.close();
        return unDomicilio;
    }
}
