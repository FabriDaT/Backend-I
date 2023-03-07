package main.com.company.DAO.impl;

import main.com.company.DAO.IDao;
import main.com.company.model.Domicilio;

import java.util.logging.Logger;

public class DomicilioDAOH2 implements IDao<Domicilio> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/test";
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

    @Override
    public void crear_BD() {

    }
    @Override
    public Domicilio guadar(Domicilio paciente) {
        return null;
    }

    @Override
    public Domicilio buscar(Long id) {
        return null;
    }

    @Override
    public Domicilio modificar(Long id) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }


}
