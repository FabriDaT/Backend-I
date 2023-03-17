package com.dh.clinicaDental.Dao;

import com.dh.clinicaDental.Model.Paciente;

import java.util.List;

public interface Idao<T> {

    List listar();
    T agregar( T elem);
    T modificar(T elem);


    void eliminar(int id);

}
