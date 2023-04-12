package com.example.clinicaodontologica.service;

import java.util.Optional;
import java.util.Set;

public interface IService <T>{
    void agregar(T t);
    void modificar(T t);
    Boolean eliminar(Integer id);
    Set<T> listar();
    Optional<T> buscar(Integer id);
}
