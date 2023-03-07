import dao.MedicamentoIDaoH2;
import dao.MedicamentoService;
import modelo.Medicamento;

public class Principal {

    public static void main(String[] args) {
        Medicamento med = new Medicamento(200, "Aspirina", "Bayer", 10000, 100.22);

        MedicamentoService service = new MedicamentoService();
        service.setMedicamentoIdao(new MedicamentoIDaoH2());

        service.guardar(med);

    }
}
