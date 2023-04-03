package com.dh.clinicaDental.proyIntegrador.Service;


import com.dh.clinicaDental.proyIntegrador.Entity.DomicilioDTO;

import java.util.Set;

public interface IDomicilioService {
    void crearDomicilio(DomicilioDTO domicilioDTO);
    DomicilioDTO leerDomicilio(Long id);
    void modificarDomicilio(DomicilioDTO domicilioDTO);
    void eliminarDomicilio(Long id);

    Set<DomicilioDTO> getTODOS();

}
