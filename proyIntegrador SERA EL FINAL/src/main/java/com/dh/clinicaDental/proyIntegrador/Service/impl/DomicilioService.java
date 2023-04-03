package com.dh.clinicaDental.proyIntegrador.Service.impl;

import com.dh.clinicaDental.proyIntegrador.Entity.Domicilio;
import com.dh.clinicaDental.proyIntegrador.Entity.DomicilioDTO;
import com.dh.clinicaDental.proyIntegrador.Repository.IDomicilioRepository;
import com.dh.clinicaDental.proyIntegrador.Service.IDomicilioService;
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
    ObjectMapper mapper;  // clase de la biblioteca Jackson, que se utiliza para convertir objetos Java en formato JSON y viceversa, para enviar respuestas HTTP en formato JSON
    private void guardarDomicilio(DomicilioDTO  domicilioDTO){
        Domicilio domicilio = mapper.convertValue(domicilioDTO , Domicilio.class);
        domicilioRepository.save(domicilio);
    }



    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);
    }

    @Override
    public DomicilioDTO leerDomicilio(Long id) {
        Optional<Domicilio> domicilio =  domicilioRepository.findById(id);
        DomicilioDTO  domicilioDTO = null;
        if (domicilio.isPresent())
            domicilioDTO =  mapper.convertValue(domicilio, DomicilioDTO.class);
        return domicilioDTO;
    }

    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO) {
        domicilioRepository.deleteById(domicilioDTO.getId());
        guardarDomicilio(domicilioDTO);
    }

    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    public Set<DomicilioDTO> getTODOS() {

        List<Domicilio> domicilios =  domicilioRepository.findAll();
        Set<DomicilioDTO> domicilioDTO = new HashSet<>();

        for (Domicilio domicilio: domicilios){
            domicilioDTO.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }
        return  domicilioDTO;

    }
}
