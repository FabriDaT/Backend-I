package com.example.clinicaodontologica.service.impl;


import com.example.clinicaodontologica.dto.PacienteDTO;

import com.example.clinicaodontologica.service.IPacienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private IPacienteService pacienteService;

    @Test
    void agregarPaciente() {
        // Creacion paciente
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("Cortez");
        pacienteDTO.setNombre("Laura");
        pacienteDTO.setEmail("laura@gmail.com");
        // Se agrega el paciente creado
        pacienteService.agregarPaciente(pacienteDTO);

        //Busqueda del paciente creado
        PacienteDTO pacienteDTO1 = pacienteService.buscarPaciente(1);

        //Verificacion de que el paciente no sea nulo
        assertTrue(pacienteDTO1!= null);
    }

    @Test
    void modificarPaciente() {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("González");
        pacienteDTO.setNombre("Jorge");
        pacienteDTO.setEmail("jorge@gmail.com");
        pacienteService.modificarPaciente(pacienteDTO);
        PacienteDTO pacienteDTO1 = pacienteService.buscarPaciente(1);
        assertEquals("González", pacienteDTO1.getApellido());
        assertEquals("Jorge", pacienteDTO1.getNombre());
        assertEquals("jorge@gmail.com", pacienteDTO1.getEmail());
    }

    @Test
    void eliminarPaciente() {
        pacienteService.eliminarPaciente(1);
        PacienteDTO pacienteDTO1 = pacienteService.buscarPaciente(1);
        assertNull(pacienteDTO1);
    }

    @Test
    void listarPacientes() {
        // Creacion varios pacientes
        PacienteDTO pacienteDTO1 = new PacienteDTO();
        pacienteDTO1.setApellido("González");
        pacienteDTO1.setNombre("Jorge");
        pacienteDTO1.setEmail("jorge@gmail.com");
        pacienteService.agregarPaciente(pacienteDTO1);

        PacienteDTO pacienteDTO2 = new PacienteDTO();
        pacienteDTO2.setApellido("Martínez");
        pacienteDTO2.setNombre("Ana");
        pacienteDTO2.setEmail("ana@gmail.com");
        pacienteService.agregarPaciente(pacienteDTO2);

        PacienteDTO pacienteDTO3 = new PacienteDTO();
        pacienteDTO3.setApellido("Pérez");
        pacienteDTO3.setNombre("Luis");
        pacienteDTO3.setEmail("luis@gmail.com");
        pacienteService.agregarPaciente(pacienteDTO3);

        // Obtener la lista de pacientes
        Set<PacienteDTO> pacientes = pacienteService.listarPacientes();

        // Verificacion que lista contiene los pacientes creados
        assertEquals(3, pacientes.size());

        assertTrue(pacientes.contains(pacienteDTO1));
        assertTrue(pacientes.contains(pacienteDTO2));
        assertTrue(pacientes.contains(pacienteDTO3));
    }

    @Test
    void buscarPaciente() {
        // Creacion de un paciente
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("González");
        pacienteDTO.setNombre("Jorge");
        pacienteDTO.setEmail("jorge@gmail.com");
        pacienteService.agregarPaciente(pacienteDTO);

        // Busqueda del paciente
        PacienteDTO pacienteEncontrado = pacienteService.buscarPaciente(1);

        // Verifica que paciente encontrado es el mismo que creamos
        assertNotNull(pacienteEncontrado);
        assertEquals("González", pacienteEncontrado.getApellido());
        assertEquals("Jorge", pacienteEncontrado.getNombre());
        assertEquals("jorge@gmail.com", pacienteEncontrado.getEmail());
    }
}