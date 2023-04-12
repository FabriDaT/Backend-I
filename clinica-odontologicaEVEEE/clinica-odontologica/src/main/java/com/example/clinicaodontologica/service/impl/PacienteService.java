package com.example.clinicaodontologica.service.impl;


import com.example.clinicaodontologica.dto.PacienteDTO;

import com.example.clinicaodontologica.entity.Paciente;

import com.example.clinicaodontologica.repository.IPacienteRepository;
import com.example.clinicaodontologica.service.IPacienteService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public PacienteDTO agregarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        return mapper.convertValue(pacienteRepository.save(paciente), PacienteDTO.class);
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public Boolean eliminarPaciente(Integer id) {
        if (pacienteRepository.findById(id).isPresent())
        {
            pacienteRepository.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public Set<PacienteDTO> listarPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTOS = new HashSet<>();
        for (Paciente paciente:pacientes){
            pacienteDTOS.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacienteDTOS;
    }

    @Override
    public PacienteDTO buscarPaciente(Integer id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent())
            pacienteDTO = mapper.convertValue(paciente,PacienteDTO.class);
        return pacienteDTO;
    }

    @Override
    public PacienteDTO findPacienteByDni(Integer dni){
        Optional<Paciente> paciente  = pacienteRepository.findPacienteByDni(dni);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent())
            pacienteDTO = mapper.convertValue(paciente,PacienteDTO.class);
        return pacienteDTO;
    }

}
