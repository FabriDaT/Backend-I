package com.dh.clinicaDental.proyIntegrador.Controller;


import com.dh.clinicaDental.proyIntegrador.Entity.DomicilioDTO;
import com.dh.clinicaDental.proyIntegrador.Service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    IDomicilioService domicilioService;

    @PostMapping("/registrar")
    public ResponseEntity<?> crearDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.crearDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  DomicilioDTO leerDomicilio(@PathVariable Long id){
        return domicilioService.leerDomicilio(id);
    }

    @GetMapping
    public Set<DomicilioDTO> traerTODOS(){
        return domicilioService.getTODOS();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.modificarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity eliminar(@PathVariable Long id) {
        ResponseEntity response = null;

        if (domicilioService.leerDomicilio(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            domicilioService.eliminarDomicilio(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    return response;
    }
}
