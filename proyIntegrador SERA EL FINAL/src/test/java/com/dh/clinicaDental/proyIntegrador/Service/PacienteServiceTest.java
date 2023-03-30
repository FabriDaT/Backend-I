package com.dh.clinicaDental.proyIntegrador.Service;

import com.dh.clinicaDental.proyIntegrador.Entity.PacienteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {
    @Autowired
    private IPacienteService pacienteService;
    @Test
    public void crearTestPacienteService(){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Fabricio");
        pacienteDTO.setApellido("Turrina");
         pacienteService.crearPaciente(pacienteDTO);


         PacienteDTO pacienteFabricio =  pacienteService.leerPaciente(1L);

         assertTrue(pacienteFabricio != null);
    }
}