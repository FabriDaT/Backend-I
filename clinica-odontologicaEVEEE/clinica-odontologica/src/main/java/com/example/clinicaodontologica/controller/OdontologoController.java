package com.example.clinicaodontologica.controller;

import com.example.clinicaodontologica.dto.OdontologoDTO;
import com.example.clinicaodontologica.dto.PacienteDTO;
import com.example.clinicaodontologica.service.IOdontologoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/odontologos")

public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;

    @PostMapping("/registrar")
    public ResponseEntity<?> agregar(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.agregarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<OdontologoDTO> obtenerTodos(){
        return odontologoService.listarOdontologos();
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscar(@PathVariable Integer id){
        return odontologoService.buscarOdontologo(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody OdontologoDTO odontologoDTO){

        odontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){

        ResponseEntity response = null;

        if(odontologoService.buscarOdontologo(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            odontologoService.eliminarOdontogolo(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @GetMapping("/mat/{matricula}")
    public OdontologoDTO buscarPorMatricula(@PathVariable String matricula){
        return odontologoService.findOdontologoByMatricula(matricula);
    }

}
