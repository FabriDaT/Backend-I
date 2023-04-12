package com.example.clinicaodontologica.controller;
import com.example.clinicaodontologica.dto.DomicilioDTO;
import com.example.clinicaodontologica.dto.OdontologoDTO;
import com.example.clinicaodontologica.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/domicilios")
public class DomicilioCotroller {
    @Autowired
    IDomicilioService domicilioService;


    @PostMapping("/registrar")
    public ResponseEntity<?> agregar(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.agregarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody DomicilioDTO domicilioDTO){

        domicilioService.modificarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DomicilioDTO buscar(@PathVariable Integer id){
        return domicilioService.buscarDomicilio(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){

        ResponseEntity response = null;

        if(domicilioService.buscarDomicilio(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            domicilioService.eliminarDomicilio(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @GetMapping
    public Collection<DomicilioDTO> obtenerTodos(){
        return domicilioService.listarDomicilios();
    }

}
