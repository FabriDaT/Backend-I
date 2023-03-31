package com.dh.clinicaDental.proyIntegrador.Service.impl;

import com.dh.clinicaDental.proyIntegrador.Entity.Odontologo;
import com.dh.clinicaDental.proyIntegrador.Entity.OdontologoDTO;
import com.dh.clinicaDental.proyIntegrador.Repository.IOdontologoRepository;
import com.dh.clinicaDental.proyIntegrador.Service.IOdontologoService;
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
    private IOdontologoRepository OdontologoRepository;
    @Autowired
    ObjectMapper mapper;  // clase de la biblioteca Jackson, que se utiliza para convertir objetos Java en formato JSON y viceversa, para enviar respuestas HTTP en formato JSON
    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        OdontologoRepository.save(odontologo);
    }

    @Override
    public void creaOdontologo(OdontologoDTO odontologoDTO) {
            guardarOdontologo(odontologoDTO);
    }

    @Override
    public OdontologoDTO leerOdontologo(Long id) {
        Optional<Odontologo> odontologo =  OdontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if (odontologo.isPresent())
            odontologoDTO =  mapper.convertValue(odontologo, OdontologoDTO.class);
        return odontologoDTO;
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);

    }

    @Override
    public void eliminarOdontologo(Long id) {
            OdontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> getTODOS() {

        List<Odontologo> odontologos =  OdontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();

        for (Odontologo odontologo: odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return  odontologosDTO;

    }
}
