package com.example.clinicaodontologica.controller;

import com.example.clinicaodontologica.dto.OdontologoDTO;
import com.example.clinicaodontologica.dto.TurnoDTO;
import com.example.clinicaodontologica.entity.Turno;
import com.example.clinicaodontologica.service.IOdontologoService;
import com.example.clinicaodontologica.service.ITurnoService;
import com.example.clinicaodontologica.service.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    @PostMapping("/registrar")
    public ResponseEntity<?> agregar(@RequestBody TurnoDTO turnoDTO){
         turnoService.agregarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<TurnoDTO> obtenerTodos(){
        return turnoService.listarTurnos();
    }

    @GetMapping("/{id}")
    public TurnoDTO buscar(@PathVariable Integer id){
        return turnoService.buscarTurno(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody TurnoDTO turnoDTO){

        turnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){

        ResponseEntity response = null;

        if(turnoService.buscarTurno(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            turnoService.eliminarTurno(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

}
