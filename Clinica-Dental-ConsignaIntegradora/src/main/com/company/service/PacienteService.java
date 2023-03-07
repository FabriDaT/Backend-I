package main.com.company.service;

import main.com.company.DAO.IDao;
import main.com.company.model.Paciente;

public class PacienteService {
    private IDao<Paciente> PacienteDao;

    public void setPacienteDao(IDao<Paciente> pacienteDao) {
        PacienteDao = pacienteDao;
    }
    public PacienteService(IDao<Paciente> pacienteDao) {
        PacienteDao = pacienteDao;
    }

    public Paciente guardar(Paciente paciente) {
        return PacienteDao.guadar(paciente);
    }

    public Paciente buscar(Long id) {
        return PacienteDao.buscar(id);
    }

    public void eliminar(Long id) {
        PacienteDao.eliminar(id);
    }

    public void modificar(Long id) {
            PacienteDao.modificar(id)
    }
    public  void crear_DB(){
        PacienteDao.crear_BD();
    }
}
