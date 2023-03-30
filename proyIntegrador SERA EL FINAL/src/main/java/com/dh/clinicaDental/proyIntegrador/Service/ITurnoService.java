package com.dh.clinicaDental.proyIntegrador.Service;

import com.dh.clinicaDental.proyIntegrador.Entity.PacienteDTO;
import com.dh.clinicaDental.proyIntegrador.Entity.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void crearTurno(TurnoDTO turnoDTO);
    TurnoDTO leerTurno(Long id);
    void modificarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id);
    Set<TurnoDTO> getTODOS();

}
