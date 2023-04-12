package com.example.clinicaodontologica.service;

import com.example.clinicaodontologica.dto.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void agregarTurno(TurnoDTO turnoDTO);
    void modificarTurno(TurnoDTO turnoDTO);
    Boolean eliminarTurno(Integer id);
    Set<TurnoDTO> listarTurnos();
    TurnoDTO buscarTurno(Integer id);
}
