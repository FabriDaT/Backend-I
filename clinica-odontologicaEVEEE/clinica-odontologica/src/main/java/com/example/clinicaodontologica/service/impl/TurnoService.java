package com.example.clinicaodontologica.service.impl;

import com.example.clinicaodontologica.dto.TurnoDTO;
import com.example.clinicaodontologica.entity.Turno;
import com.example.clinicaodontologica.repository.ITurnoRepository;
import com.example.clinicaodontologica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void agregarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO,Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO,Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public Boolean eliminarTurno(Integer id) {
        if (turnoRepository.findById(id).isPresent())
        {
            turnoRepository.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public Set<TurnoDTO> listarTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnoDTOS = new HashSet<>();
        for (Turno turno:turnos){
            turnoDTOS.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnoDTOS;
    }

    @Override
    public TurnoDTO buscarTurno(Integer id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent())
            turnoDTO = mapper.convertValue(turno,TurnoDTO.class);
        return turnoDTO;
    }



   /* private final ITurnoRepository turnoRepository;

    public TurnoService(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public Turno agregar(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Turno modificar(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Boolean eliminar(Integer id) {
        if (turnoRepository.findById(id).isPresent())
        {
            turnoRepository.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public Set<Turno> listar() {

        List<Turno> turnos = turnoRepository.findAll();
        Set<Turno> turnosSet =
    }

    @Override
    public Optional<Turno> buscar(Integer id) {
        return turnoRepository.findById(id);
    }*/
}
