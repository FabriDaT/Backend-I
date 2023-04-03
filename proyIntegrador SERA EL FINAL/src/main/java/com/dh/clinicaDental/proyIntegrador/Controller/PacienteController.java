package com.dh.clinicaDental.proyIntegrador.Controller;

import com.dh.clinicaDental.proyIntegrador.Entity.PacienteDTO;
import com.dh.clinicaDental.proyIntegrador.Service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    IPacienteService pacienteService;

    @PostMapping("/registrar")
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public PacienteDTO leerPaciente(@PathVariable Long id){
        return pacienteService.leerPaciente(id);
    }

    @GetMapping
    public Set<PacienteDTO> traerTODOS(){
        return  pacienteService.getTODOS();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@RequestBody PacienteDTO pacienteDTO){

        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){

        ResponseEntity response = null;

        if(pacienteService.leerPaciente(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            pacienteService.eliminarPaciente(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }
}
