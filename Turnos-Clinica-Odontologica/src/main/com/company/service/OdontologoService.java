package main.com.company.service;

import main.com.company.dao.IDao;
import main.com.company.entity.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> OdontologoDao;

    public IDao<Odontologo> getOdontologoIDao() {
        return OdontologoDao;
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
        OdontologoDao = odontologoIDao;
    }
    public List<Odontologo> ListarOdontologos(){
        return OdontologoDao.listar();
    }
    public Odontologo agregarOdontologo(Odontologo odontologo){
        return OdontologoDao.agregar(odontologo);
    }
    public Odontologo modifcarOdontologo(Long id){
        return OdontologoDao.modificar(id);
    }
    public void eliminarOdontologo(Long id){
        OdontologoDao.eliminar(id);
    }

    public void crearBD(){
        OdontologoDao.createDB();
    }
}
