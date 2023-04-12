package com.example.clinicaodontologica.service.impl;

import com.example.clinicaodontologica.dto.OdontologoDTO;
import com.example.clinicaodontologica.service.IOdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    @Test
    public void AgregarOdontologo() {
        // Creacion odontologo
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setApellido("Lopez");
        odontologoDTO.setNombre("Mauricio");
        odontologoDTO.setMatricula("DFR343");
        // Se agrega el odontologo creado
        odontologoService.agregarOdontologo(odontologoDTO);
        //Busqueda del odontologo creado
        OdontologoDTO odontologoDTO1 = odontologoService.buscarOdontologo(1);
        //Verificacion de que el odontologo no sea nulo
        assertTrue(odontologoDTO1!= null);
    }

    @Test
    void modificarOdontologo() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setApellido("González");
        odontologoDTO.setNombre("Jorge");
        odontologoDTO.setMatricula("sddw333");
        odontologoService.modificarOdontologo(odontologoDTO);
        OdontologoDTO odontologoDTO1 = odontologoService.buscarOdontologo(1);
        assertEquals("González", odontologoDTO1.getApellido());
        assertEquals("Jorge", odontologoDTO1.getNombre());
        assertEquals("sddw333", odontologoDTO1.getMatricula());
    }

    @Test
    void eliminarOdontogolo() {
        odontologoService.eliminarOdontogolo(1);
        OdontologoDTO odontologoDTO1 =  odontologoService.buscarOdontologo(1);
        assertNull(odontologoDTO1);
    }

    @Test
    void listarOdontologos() {
        // Creacion varios odontologos
        OdontologoDTO odontologoDTO1 = new OdontologoDTO();
        odontologoDTO1.setApellido("González");
        odontologoDTO1.setNombre("Jorge");
        odontologoDTO1.setMatricula("sddw393");
        odontologoService.agregarOdontologo(odontologoDTO1);

        OdontologoDTO odontologoDTO2 = new OdontologoDTO();
        odontologoDTO2.setApellido("Martínez");
        odontologoDTO2.setNombre("Ana");
        odontologoDTO2.setMatricula("tytr5555");
        odontologoService.agregarOdontologo(odontologoDTO2);

        OdontologoDTO odontologoDTO3 = new OdontologoDTO();
        odontologoDTO3.setApellido("Pérez");
        odontologoDTO3.setNombre("Luis");
        odontologoDTO3.setMatricula("tgf5375");
        odontologoService.agregarOdontologo(odontologoDTO3);

        // Obtener la lista de odontologos
        Set<OdontologoDTO> odontologos = odontologoService.listarOdontologos();

        // Verificacion que lista contiene los odontologos creados
        assertEquals(3, odontologos.size());

        assertTrue(odontologos.contains(odontologoDTO1));
        assertTrue(odontologos.contains(odontologoDTO2));
        assertTrue(odontologos.contains(odontologoDTO3));
    }

    @Test
    void buscarOdontologo() {
        // Creacion de un odontologo
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setApellido("González");
        odontologoDTO.setNombre("Jorge");
        odontologoDTO.setMatricula("sde124");
        odontologoService.agregarOdontologo(odontologoDTO);

        // Busqueda del odontologo
        OdontologoDTO odontologoEncontrado = odontologoService.buscarOdontologo(1);

        // Verifica que odontologo encontrado es el mismo que creamos
        assertNotNull(odontologoEncontrado);
        assertEquals("González", odontologoEncontrado.getApellido());
        assertEquals("Jorge", odontologoEncontrado.getNombre());
        assertEquals("sde124", odontologoEncontrado.getMatricula());
    }
}