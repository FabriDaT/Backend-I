package dao;

import modelo.Medicamento;

import java.sql.*;

public class MedicamentoIDaoH2 implements IDao <Medicamento>{
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:c://GIT//DH//BACKEND0223//Clase14//Farmacia";
    private final static String DB_USER ="rick";
    private final static String DB_PASSWORD = "";

    private Connection con = null;


    @Override
    public Medicamento buscar(long id) {

        Medicamento m = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement pmst = con.prepareStatement("SELECT * FROM medicamento WHERE id = ?;");
            pmst.setLong(1, id);
            ResultSet rs = pmst.executeQuery();
            if (rs.next()){
               m = new Medicamento(id, rs.getString(2),
                                       rs.getString(3),
                                       rs.getInt(4),
                                       rs.getDouble(5)) ;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return m;


    }

    @Override
    public Medicamento guardar(Medicamento medicamento) {

        try {
            Class.forName(DB_JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement pmst = con.prepareStatement("INSERT INTO MEDICAMENTO VALUES (?,?,?,?,?);");
            pmst.setLong(1, medicamento.getId());
            pmst.setString(2, medicamento.getNombre());
            pmst.setString(3,medicamento.getLaboratorio());
            pmst.setInt(4, medicamento.getCantidad());
            pmst.setDouble(5, medicamento.getPrecio());
            pmst.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return medicamento;
    }
}
