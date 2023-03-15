package com.dh.clinicaDental.Dao;

import java.util.List;

public interface Idao<T> {

    List listar();
    T agregar( T elem);
    T modificar(T elem);
    void eliminar(int id);

}
