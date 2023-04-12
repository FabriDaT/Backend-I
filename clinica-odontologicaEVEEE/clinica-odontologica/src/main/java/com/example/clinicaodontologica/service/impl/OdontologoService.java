package com.example.clinicaodontologica.service.impl;

import com.example.clinicaodontologica.dto.OdontologoDTO;
import com.example.clinicaodontologica.dto.PacienteDTO;
import com.example.clinicaodontologica.entity.Odontologo;
import com.example.clinicaodontologica.entity.Paciente;
import com.example.clinicaodontologica.repository.IOdontologoRepository;
import com.example.clinicaodontologica.service.IOdontologoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void agregarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO,Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO,Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public Boolean eliminarOdontogolo(Integer id) {
        if (odontologoRepository.findById(id).isPresent())
        {
            odontologoRepository.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public Set<OdontologoDTO> listarOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOS = new HashSet<>();
        for (Odontologo odontologo:odontologos){
            odontologoDTOS.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologoDTOS;
    }

    @Override
    public OdontologoDTO buscarOdontologo(Integer id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent())
            odontologoDTO = mapper.convertValue(odontologo,OdontologoDTO.class);
        return odontologoDTO;
    }

    @Override
    public OdontologoDTO findOdontologoByMatricula(String matricula) {
        Optional<Odontologo> odontologo  = odontologoRepository.findOdontoloByMatricula(matricula);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent())
            odontologoDTO = mapper.convertValue(odontologo,OdontologoDTO.class);
        return odontologoDTO;
    }


}
