package com.dh.clinicaDental.proyIntegrador.Service;

import com.dh.clinicaDental.proyIntegrador.Entity.Domicilio;
import com.dh.clinicaDental.proyIntegrador.Entity.DomicilioDTO;
import com.dh.clinicaDental.proyIntegrador.Repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class DomicilioService implements  IDomicilioService{

    @Autowired
    private IDomicilioRepository DomicilioRepository;
    @Autowired
    ObjectMapper mapper;  // clase de la biblioteca Jackson, que se utiliza para convertir objetos Java en formato JSON y viceversa, para enviar respuestas HTTP en formato JSON
    private void guardarDomicilio(DomicilioDTO  domicilioDTO){
        Domicilio domicilio = mapper.convertValue(domicilioDTO , Domicilio.class);
        DomicilioRepository.save(domicilio);
    }



    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) {

    }

    @Override
    public DomicilioDTO leerDomicilio(Long id) {
        return null;
    }

    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO) {

    }

    @Override
    public void eliminarPaciente(Long id) {

    }

    @Override
    public Set<DomicilioDTO> getTODOS() {
        return null;
    }
}
