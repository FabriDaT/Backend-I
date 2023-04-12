package com.example.clinicaodontologica.controller;

import com.example.clinicaodontologica.dto.OdontologoDTO;
import com.example.clinicaodontologica.dto.PacienteDTO;
import com.example.clinicaodontologica.entity.Paciente;
import com.example.clinicaodontologica.service.IPacienteService;
import com.example.clinicaodontologica.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    @PostMapping("/registrar")
    public ResponseEntity<?> agregar(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.agregarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<PacienteDTO> obtenerTodos(){
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}")
    public PacienteDTO buscar(@PathVariable Integer id){
        return pacienteService.buscarPaciente(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody PacienteDTO pacienteDTO){

        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){

        ResponseEntity response = null;

        if(pacienteService.buscarPaciente(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            pacienteService.eliminarPaciente(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @GetMapping("/dni/{dni}")
    public PacienteDTO buscarPorDni(@PathVariable Integer dni){
        return pacienteService.findPacienteByDni(dni);
    }

}
