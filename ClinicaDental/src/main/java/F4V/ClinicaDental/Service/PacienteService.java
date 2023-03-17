package F4V.ClinicaDental.Service;

import F4V.ClinicaDental.DAO.IDao;
import F4V.ClinicaDental.DAO.Impl.PacienteDaoH2;
import F4V.ClinicaDental.Model.Paciente;
import java.util.List;



public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public IDao<Paciente> getPacienteIDao() {
        return pacienteIDao;
    }

    public void setPacienteIDao(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardar(Paciente p){
        return pacienteIDao.guardar(p);
    }
    public Paciente buscar(int id){
        return pacienteIDao.buscar(id);
    }
    public List<Paciente> buscarTodos(){
        return pacienteIDao.buscarTodos();
    }
    public void eliminar(int id){
        pacienteIDao.eliminar(id);
    }

    public void actualizar(Paciente p){
        pacienteIDao.actualizar(p);
    }




}
