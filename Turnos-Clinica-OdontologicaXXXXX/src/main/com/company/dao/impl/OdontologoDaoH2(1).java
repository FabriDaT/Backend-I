package main.com.company.dao.impl;

import main.com.company.dao.IDao;
import main.com.company.entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        ConfigJDBC configJDBC = new ConfigJDBC();
        return configJDBC.getConnection();
    }

    private PreparedStatement getPreparedStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    @Override
    public void crearTB(){
        try {
            Connection connection = getConnection();
            PreparedStatement psCrearTB = getPreparedStatement(connection,
                    StatementGenerator.getStatement("createTBOdont"));
            psCrearTB.execute();
            psCrearTB.close();

            logger.info("Se creo la tabla en la Base de datos");
        }
        catch (SQLException | ClassNotFoundException e){
            logger.error("Error al crear la tabla en la base de datos", e);
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Odontologo agregar(Odontologo odontologo){

        try {
            PreparedStatement psAgregar= getPreparedStatement(getConnection(), StatementGenerator.getStatement("insertInOdont"));

            psAgregar.setLong(1, odontologo.getId());
            psAgregar.setString(2, odontologo.getApellido());
            psAgregar.setString(3, odontologo.getNombre());
            psAgregar.setString(4, odontologo.getMatricula());
            logger.info("Odontologo " + odontologo.getId() + " agregado");
            psAgregar.execute();
            psAgregar.close();

        }
        catch (SQLException | ClassNotFoundException e){
            logger.error("Error al agregar odontologo", e);
            System.out.println(e.getMessage());
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

    @Override
    public List<Odontologo> listar() {

        List<Odontologo> odontologos = new ArrayList<>();

        try{
            PreparedStatement psListar = getPreparedStatement(getConnection(), StatementGenerator.getStatement("selectAllOdont"));
            ResultSet rs = psListar.executeQuery();

            while (rs.next()){
                Long id = rs.getLong("id");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                String matricula = rs.getString("matricula");

                odontologos.add(new Odontologo(id, apellido, nombre, matricula));
            }
            psListar.close();

        }catch (SQLException | ClassNotFoundException e){
            logger.error("Error al listar los odontologos", e);
            System.out.println(e.getMessage());
        }
        return odontologos;
    }
}
