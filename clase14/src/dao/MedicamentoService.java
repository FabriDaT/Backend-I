package dao;

import modelo.Medicamento;

public class MedicamentoService {

    IDao <Medicamento> medicamentoIdao;

    public IDao<Medicamento> getMedicamentoIdao() {
        return medicamentoIdao;
    }

    public void setMedicamentoIdao(IDao<Medicamento> medicamentoIdao) {
        this.medicamentoIdao = medicamentoIdao;
    }

    public Medicamento buscar(long id){
        return medicamentoIdao.buscar(id);
    };

    public Medicamento guardar(Medicamento med){
        return medicamentoIdao.guardar(med);
    };

}
