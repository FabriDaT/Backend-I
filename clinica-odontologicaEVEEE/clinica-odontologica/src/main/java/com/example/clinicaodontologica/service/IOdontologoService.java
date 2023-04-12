package com.example.clinicaodontologica.service;

import com.example.clinicaodontologica.dto.OdontologoDTO;
import com.example.clinicaodontologica.dto.PacienteDTO;

import java.util.Set;

public interface IOdontologoService {
    void agregarOdontologo(OdontologoDTO odontologoDTO);
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    Boolean eliminarOdontogolo(Integer id);
    Set<OdontologoDTO> listarOdontologos();
    OdontologoDTO buscarOdontologo(Integer id);

    OdontologoDTO findOdontologoByMatricula(String matricula);
}
