package main.com.company.DAO.impl;

import main.com.company.DAO.IDao;
import main.com.company.model.Paciente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class PacienteDAOH2 implements IDao<Paciente> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "fabri";
    private final static String DB_PASSWORD = "";
    private final static String DB_SQL_CREATE = "create table IF NOT EXISTS Paciente(id BIGINT AUTO_INCREMENT PRIMARY KEY, nombre varchar(255),apellido varchar (255), matricula(255))";
    private static final Logger logger = Logger.getLogger(String.valueOf(PacienteDAOH2.class));

        @Override
        public void crear_BD() {
            Connection connection = null;
            PreparedStatement pst = null;
            try {
                Class.forName(DB_JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
                pst = connection.prepareStatement(DB_SQL_CREATE);
                pst.close();

                logger.info("Base de datos creada!");
            }
            catch (SQLException | ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
    @Override
    public Paciente guadar(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente buscar(Long id) {
        return null;
    }

    @Override
    public Paciente modificar(Long id) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }


    }
}
