package com.dh.clinicaDental.proyIntegrador.Controller;

import com.dh.clinicaDental.proyIntegrador.Entity.PacienteDTO;
import com.dh.clinicaDental.proyIntegrador.Service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> crarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  PacienteDTO getPaciente(@PathVariable Long id){
        return pacienteService.leerPaciente(id);
    }

}
