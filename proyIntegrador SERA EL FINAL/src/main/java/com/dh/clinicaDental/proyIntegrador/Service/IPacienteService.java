package com.dh.clinicaDental.proyIntegrador.Service;

import com.dh.clinicaDental.proyIntegrador.Entity.PacienteDTO;
import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO leerPaciente(Long id);
    void modificarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Long id);
    Set<PacienteDTO> getTODOS();

}
