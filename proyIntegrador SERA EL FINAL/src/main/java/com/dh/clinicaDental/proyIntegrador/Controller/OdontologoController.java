package com.dh.clinicaDental.proyIntegrador.Controller;

import com.dh.clinicaDental.proyIntegrador.Entity.OdontologoDTO;
import com.dh.clinicaDental.proyIntegrador.Service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    IOdontologoService odontologoService;

    @PostMapping("/registrar")
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.crearOdontologo(odontologoDTO);
        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO leerOdontologo(@PathVariable Long id){
        return odontologoService.leerOdontologo(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.modificarOdontologo(odontologoDTO);
        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<OdontologoDTO> traerTODOS(){
        return odontologoService.getTODOS();
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity eliminar(@PathVariable Long id){
        ResponseEntity response = null;

        if (odontologoService.leerOdontologo(id)== null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else {
            odontologoService.eliminarOdontologo(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

}
