import org.junit.jupiter.api.Test;
import model.Medicamento;
import services.MedicamentoService;
import daos.impl.MedicamentoIDAOH2;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MedicamentoServiceTest {
  @Test
  void insertamosMedicamentoYLoBuscamosEnBBDDxNombre() throws SQLException, ClassNotFoundException {
    
    Medicamento ibuprofeno= new Medicamento(1, "Ibuprofeno", "Bayer", 100, 2.5);
    
    MedicamentoService medicamentoService = new MedicamentoService();
    medicamentoService.setMedicamentoIDao(new MedicamentoIDAOH2());
    medicamentoService.createDB();
    
    medicamentoService.guardar(ibuprofeno);
    
    Medicamento medicamentoBuscado= medicamentoService.buscarXNombre("Ibuprofeno");
    assertEquals(ibuprofeno.getNombre(), medicamentoBuscado.getNombre());
  }
  
  @Test
  void insertamosMedicamentoYLoBuscamosEnBBDDxID() throws SQLException, ClassNotFoundException {
    
    Medicamento ibuprofeno= new Medicamento(1, "Ibuprofeno", "Bayer", 100, 2.5);
    
    MedicamentoService medicamentoService = new MedicamentoService();
    medicamentoService.setMedicamentoIDao(new MedicamentoIDAOH2());
    medicamentoService.createDB();
    
    medicamentoService.guardar(ibuprofeno);
    
    Medicamento medicamentoBuscado= medicamentoService.buscarXId(1);
    assertEquals(ibuprofeno.getCodigoNumerico(), medicamentoBuscado.getCodigoNumerico());
  }
  
  
}