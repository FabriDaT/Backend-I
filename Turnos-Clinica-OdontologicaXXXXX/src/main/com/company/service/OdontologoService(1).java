package main.com.company.service;

import main.com.company.dao.IDao;
import main.com.company.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoDao;

    public OdontologoService() {
    }

    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public IDao<Odontologo> getOdontologoDao() {
        return odontologoDao;
    }

    public void setOdontologoDao(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public void createTB() {
        odontologoDao.crearTB();
    }

    public List<Odontologo> listarOdontologos(){
        return odontologoDao.listar();
    }

    public Odontologo agregarOdontologo(Odontologo odontologo){
        return odontologoDao.agregar(odontologo);
    }

    public Odontologo modificarOdontologo(Long id){
        return odontologoDao.modificar(id);
    }

    public void eliminarOdontologo(Long id){
        odontologoDao.eliminar(id);
    }

}
