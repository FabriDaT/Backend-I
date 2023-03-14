package main.com.company.DAO.impl;

import main.com.company.DAO.IDao;
import main.com.company.model.Paciente;

import java.sql.*;
import java.util.logging.Logger;

public class PacienteDAOH2 implements IDao<Paciente> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/DB_Pacientes;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER = "fabri";
    private final static String DB_PASSWORD = "";
    private final static String DB_SQL_CREATE = "DROP TABLE IF EXISTS PACIENTES;" + "CREATE TABLE PACIENTES (" +
            "  id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "  nombre VARCHAR(50) NOT NULL,\n" +
            "  apellido VARCHAR(50) NOT NULL,\n" +
            "  dni VARCHAR(10) NOT NULL,\n" +
            "  fechaIngreso DATE NOT NULL,\n" +
            "  domicilio_id INT NOT NULL,\n" +
            "  FOREIGN KEY (domicilio_id) REFERENCES DOMICILIO(id)\n" +
            "); ";
    private static final Logger logger = Logger.getLogger(String.valueOf(PacienteDAOH2.class));

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
    public Paciente leer(int id) {
        return null;
    }

    @Override
    public Paciente guardar(Paciente unPaciente) {
        DomicilioDAOH2 d = new DomicilioDAOH2();
        d.guardar(unPaciente.getID_domicilio());


        Connection coneccion = con();
        PreparedStatement ps = coneccion.prepareStatement("INSERT INTO PACIENTES(nombre, apellido, dni, fehcaIngreso, domicilio_id) VALUES" +
                "(?, ?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,unPaciente.getNombre());
        ps.setInt(2,unPaciente.getApellido());
        ps.setString(3,unPaciente.getDNI());
        ps.setString(4,unPaciente.getFechaDeIngreso());
        ps.setInt(5,unPaciente.getID_domicilio());
        ps.executeUpdate();

        ResultSet keys = ps.getGeneratedKeys();
        while(keys.next()){
            unPaciente.setId(keys.getLong(1));
        }

        ps.close();
        return unDomicilio;
    }
}

