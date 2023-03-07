import model.Medicamento;
import services.MedicamentoService;
import daos.impl.MedicamentoIDAOH2;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try{

            Medicamento ibuprofeno= new Medicamento(1, "ibuprofeno", "farmacia", 100, 2.5);

            MedicamentoService medicamentoService = new MedicamentoService();
            medicamentoService.setMedicamentoIDao(new MedicamentoIDAOH2());
            medicamentoService.createDB();
            medicamentoService.guardar(ibuprofeno);

            Medicamento medicamentoBuscado= medicamentoService.buscarXNombre("ibuprofeno");
            Medicamento medicamentoBuscado2= medicamentoService.buscarXId(10);

        }
        catch (SQLException e){
            System.out.println(e.getMessage() + "sql error");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}