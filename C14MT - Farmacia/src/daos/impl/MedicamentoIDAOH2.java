package daos.impl;

import daos.IDao;
import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;


public class MedicamentoIDAOH2 implements IDao<Medicamento> {
  private static final Logger logger = Logger.getLogger(MedicamentoIDAOH2.class);

  private Connection getConnection() throws SQLException, ClassNotFoundException {
    ConfigJDBC configJDBC = new ConfigJDBC();
    return configJDBC.getConnection();
  }
  
  private PreparedStatement getPreparedStatement(Connection conexion, String sql) throws SQLException {
    return conexion.prepareStatement(sql);
  }
  
  @Override
  public void createDB() {
    try {
      Connection conexion = getConnection();
      PreparedStatement psCrearDB = getPreparedStatement(conexion,
          StatementGenerator.getStatement("createDB"));
      psCrearDB.execute();
      psCrearDB.close();
      
      logger.info("Base de datos creada");
    }
    catch (SQLException | ClassNotFoundException e){
      logger.error("Error al crear base de datos", e);
      System.out.println(e.getMessage());
    }
  }
  
  @Override
  public void guardar(Medicamento medicamento)  {
    try {
      PreparedStatement psGuardar= getPreparedStatement(getConnection(),
          StatementGenerator.getStatement("insert"));
      
      psGuardar.setLong(1, medicamento.getCodigoNumerico());
      psGuardar.setString(2, medicamento.getNombre());
      psGuardar.setString(3, medicamento.getLaboratorio());
      psGuardar.setLong(4, medicamento.getCantidad());
      psGuardar.setDouble(5, medicamento.getPrecio());
      logger.info("Medicamento guardado: " + medicamento);
      psGuardar.execute();
      psGuardar.close();
      
    }
    catch (SQLException | ClassNotFoundException e){
      logger.error("Error al guardar medicamento", e);
      System.out.println(e.getMessage());
    }
  }
  
  @Override
  public Medicamento buscarXNombre(String Nombre) {
    try {
      PreparedStatement psBuscarName= getPreparedStatement(getConnection(),
          StatementGenerator.getStatement("selectWhereNombre"));
      psBuscarName.setString(1, Nombre);
      Medicamento medicamento = getMedicamento(psBuscarName);
      if (medicamento != null) return medicamento;
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println(e.getMessage());
      
    }
    return null;
  }
  
  @Override
  public Medicamento buscarXId(long id) {
    try {
      PreparedStatement psBuscarId= getPreparedStatement(getConnection(),
          StatementGenerator.getStatement("selectWhereCodNum"));
      psBuscarId.setLong(1, id);
      Medicamento medicamento = getMedicamento(psBuscarId);
      if (medicamento != null) return medicamento;
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }
  
  private Medicamento getMedicamento(PreparedStatement psBuscar) throws SQLException {
    ResultSet resultado= psBuscar.executeQuery();
    
    if (resultado.next()){
      Medicamento medicamento= new Medicamento();
      medicamento.setCodigoNumerico(resultado.getLong("codigoNumerico"));
      medicamento.setNombre(resultado.getString("nombre"));
      medicamento.setLaboratorio(resultado.getString("laboratorio"));
      medicamento.setCantidad(resultado.getInt("cantidad"));
      medicamento.setPrecio(resultado.getDouble("precio"));
      logger.info("Medicamento encontrado: " + medicamento);
      psBuscar.close();
      return medicamento;
    }
    logger.error("Medicamento no encontrado");
    return null;
  }
}

