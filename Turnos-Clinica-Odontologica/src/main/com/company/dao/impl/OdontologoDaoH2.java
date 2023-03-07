package main.com.company.dao.impl;

import main.com.company.dao.IDao;
import main.com.company.entity.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "fabri";
    private final static String DB_PASSWORD = "";
    private final static String DB_SQL_CREATE = "create table IF NOT EXISTS odontologos(id BIGINT PRIMARY KEY, nombre varchar(255),apellido varchar (255), matricula(255))";
    private static final Logger logger = Logger.getLogger(String.valueOf(OdontologoDaoH2.class));
    @Override
    public void createDB() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
           preparedStatement = connection.prepareStatement(DB_SQL_CREATE);
          preparedStatement.close();

            logger.info("Base de datos creada");
        }
        catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Odontologo> listar() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id");
                String nom = rs.getString("nombre");
                String apell = rs.getString("apellido");
                String matri = rs.getString("matricula");
                odontologos.add(new Odontologo(id,nom,apell,matri) );
              //  System.out.println("id: "+id+"Nombre: "+nom+"Apellido: "+apell+"Matricula: "+matri+"\n");
            }
            preparedStatement.close();

        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        }
        return odontologos;
    }

    @Override
    public Odontologo agregar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
           Class.forName(DB_JDBC_DRIVER);
           connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

           preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS(?,?,?,?)");
           preparedStatement.setLong(1,odontologo.getId());
           preparedStatement.setString(2,odontologo.getNombre());
           preparedStatement.setString(3,odontologo.getApellido());
           preparedStatement.setString(4, odontologo.getMatricula());
           preparedStatement.executeUpdate();
           preparedStatement.close();

        }catch (SQLException | ClassNotFoundException throwables)
        {
            throwables.printStackTrace();
        }

        return odontologo;
    }

    @Override
    public Odontologo modificar(Long id) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }
}
