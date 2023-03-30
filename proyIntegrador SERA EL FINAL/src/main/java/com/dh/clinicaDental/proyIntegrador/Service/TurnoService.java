package com.dh.clinicaDental.proyIntegrador.Service;

import com.dh.clinicaDental.proyIntegrador.Entity.*;
import com.dh.clinicaDental.proyIntegrador.Repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class TurnoService implements  ITurnoService{

    @Autowired
    private ITurnoRepository TurnoRepository;
    @Autowired
    ObjectMapper mapper;  // clase de la biblioteca Jackson, que se utiliza para convertir objetos Java en formato JSON y viceversa, para enviar respuestas HTTP en formato JSON
    private void guardarTurno(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        TurnoRepository.save(turno);
    }


    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
            guardarTurno(turnoDTO);
    }

    @Override
    public TurnoDTO leerTurno(Long id) {
        Optional<Turno> turno =  TurnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if (turno.isPresent())
            turnoDTO =  mapper.convertValue(turno, TurnoDTO.class);
        return turnoDTO;
    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
            guardarTurno(turnoDTO);
    }

    @Override
    public void eliminarTurno(Long id) {
        TurnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDTO> getTODOS() {

        List<Turno> turnos =  TurnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();

        for (Turno turno: turnos){
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return  turnosDTO;
    }
}
