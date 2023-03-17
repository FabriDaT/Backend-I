package F4V.ClinicaDental.Service;

import F4V.ClinicaDental.DAO.IDao;
import F4V.ClinicaDental.Model.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public void OdontoloService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardar(Odontologo o){
        return odontologoIDao.guardar(o);
    }
    public Odontologo buscar(int id){
        return odontologoIDao.buscar(id);
    }
    public List<Odontologo> buscarTodos(){
        return odontologoIDao.buscarTodos();
    }
    public void eliminar(int id){
        odontologoIDao.eliminar(id);
    }

    public void actualizar(Odontologo o){
        odontologoIDao.actualizar(o);
    }


}
