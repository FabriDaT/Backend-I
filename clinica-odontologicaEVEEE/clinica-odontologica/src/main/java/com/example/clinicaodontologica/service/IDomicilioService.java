package com.example.clinicaodontologica.service;

import com.example.clinicaodontologica.dto.DomicilioDTO;
import com.example.clinicaodontologica.dto.OdontologoDTO;

import java.util.Set;


public interface IDomicilioService {
    DomicilioDTO agregarDomicilio(DomicilioDTO domicilioDTO);
    void modificarDomicilio(DomicilioDTO domicilioDTO);
    Boolean eliminarDomicilio(Integer id);
    DomicilioDTO buscarDomicilio(Integer id);
    Set<DomicilioDTO> listarDomicilios();
}
