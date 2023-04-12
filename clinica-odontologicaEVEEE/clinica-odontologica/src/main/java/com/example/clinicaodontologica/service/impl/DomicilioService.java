package com.example.clinicaodontologica.service.impl;

import com.example.clinicaodontologica.dto.DomicilioDTO;

import com.example.clinicaodontologica.dto.OdontologoDTO;
import com.example.clinicaodontologica.entity.Domicilio;

import com.example.clinicaodontologica.entity.Odontologo;
import com.example.clinicaodontologica.repository.IDomicilioRepository;

import com.example.clinicaodontologica.service.IDomicilioService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public DomicilioDTO agregarDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        return mapper.convertValue(domicilioRepository.save(domicilio),DomicilioDTO.class);
    }

    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }

    @Override
    public Boolean eliminarDomicilio(Integer id) {
        if (domicilioRepository.findById(id).isPresent()) {
            domicilioRepository.deleteById(id);
            return true;
        } else
            return false;
    }

    @Override
    public DomicilioDTO buscarDomicilio(Integer id) {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if (domicilio.isPresent())
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        return domicilioDTO;
    }

    @Override
    public Set<DomicilioDTO> listarDomicilios() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        Set<DomicilioDTO> domicilioDTOS = new HashSet<>();
        for (Domicilio domicilio:domicilios){
            domicilioDTOS.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }
        return domicilioDTOS;
    }


}
