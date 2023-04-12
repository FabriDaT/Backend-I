package com.example.clinicaodontologica.service;

import com.example.clinicaodontologica.dto.PacienteDTO;

import java.util.Set;

public interface IPacienteService {
    PacienteDTO agregarPaciente(PacienteDTO pacienteDTO);
    void modificarPaciente(PacienteDTO pacienteDTO);
    Boolean eliminarPaciente(Integer id);
    Set<PacienteDTO> listarPacientes();
    PacienteDTO buscarPaciente(Integer id);

    PacienteDTO findPacienteByDni(Integer dni);
}
