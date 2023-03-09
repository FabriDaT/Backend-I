package main.com.company.dao.impl;

import main.com.company.dao.IDao;
import main.com.company.entity.Odontologo;

import java.util.List;

public class OdontologoDaoEnMemoria implements IDao<Odontologo> {

    private List<Odontologo> odontologosRepositorio;

    public OdontologoDaoEnMemoria(List<Odontologo> odontologosRepositorio) {
        this.odontologosRepositorio = odontologosRepositorio;
    }

    @Override
    public void crearTB() {

    }

    @Override
    public Odontologo agregar(Odontologo odontologo) {
        odontologosRepositorio.add(odontologo);
        return odontologo;
    }

    @Override
    public Odontologo modificar(Long id) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Odontologo> listar() {
        return odontologosRepositorio;
    }
}
