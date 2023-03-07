package services;

import daos.IDao;
import model.Medicamento;

import java.sql.SQLException;

public class MedicamentoService  {
  
  private IDao<Medicamento> medicamentoIDao;
  
  public void setMedicamentoIDao(IDao<Medicamento> medicamentoIDao) {
    this.medicamentoIDao = medicamentoIDao;
  }
  
  public void guardar(Medicamento medicamento) throws SQLException, ClassNotFoundException {
    medicamentoIDao.guardar(medicamento);
    
  }
  
  public Medicamento buscarXNombre(String Nombre) {
    return medicamentoIDao.buscarXNombre(Nombre);
  }
  
  public Medicamento buscarXId(long id) {
    return medicamentoIDao.buscarXId(id);
  }
  
  public void createDB() {
    medicamentoIDao.createDB();
  }
}
