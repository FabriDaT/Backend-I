package com.dh.clinicaDental.proyIntegrador.Service;

import com.dh.clinicaDental.proyIntegrador.Entity.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {

    void creaOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO leerOdontologo(Long id);
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id);
    Set<OdontologoDTO> getTODOS();

}
