package main.com.company.dao;

import java.util.List;

public interface IDao <T>{

    public void crearTB();

    public T agregar(T t);

    public T modificar(Long id);

    public void eliminar(Long id);

    public List<T> listar();
}
