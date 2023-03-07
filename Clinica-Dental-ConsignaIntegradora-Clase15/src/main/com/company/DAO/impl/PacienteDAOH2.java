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
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private final static String DB_USER = "fabri";
    private final static String DB_PASSWORD = "";
    private final static String DB_SQL_CREATE = "DROP TABLE IF EXISTS PACIENTES;" + "CREATE TABLE PACIENTES (" +
            "  id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "  nombre VARCHAR(50) NOT NULL,\n" +
            "  apellido VARCHAR(50) NOT NULL,\n" +
            "  dni VARCHAR(10) NOT NULL,\n" +
            "  fecha_ingreso DATE NOT NULL,\n" +
            "  domicilio_id INT NOT NULL,\n" +
            "  FOREIGN KEY (domicilio_id) REFERENCES DOMICILIO(id)\n" +
            "); ";
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
            try{
                Class.forName(DB_JDBC_DRIVER);
                Connection conec = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
                PreparedStatement pst = null;
                pst = conec.prepareStatement("INSERT INTO PACIENTES (id, nombre, apellido, dni, fecha_ingreso, domicilio_id)" +
                        "VALUES (?, ?, ?, ?, ?, ?)");
                pst.setLong(1,paciente.getId());
                pst.setString(2, paciente.getNombre());
                pst.setString(3,paciente.getApellido());
                pst.setString(4,paciente.getDNI());
                pst.setDate(5,paciente.getFechaDeIngreso());
                pst.setLong(6, paciente.getDomicilio().getId());

                pst.executeUpdate();
                pst.close();
            }
            catch (Exception e) {
                logger.info(" guardando paciente" + e);
            }


            return paciente;
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

