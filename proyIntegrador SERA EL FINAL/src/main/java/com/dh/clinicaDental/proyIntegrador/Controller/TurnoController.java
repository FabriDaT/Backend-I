package com.dh.clinicaDental.proyIntegrador.Controller;

import com.dh.clinicaDental.proyIntegrador.Entity.TurnoDTO;
import com.dh.clinicaDental.proyIntegrador.Service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    @PostMapping("/{id}")
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  TurnoDTO leerTurno(@PathVariable Long id){
        return  turnoService.leerTurno(id);
    }

    @GetMapping
    public Set<TurnoDTO> traerTODOS(){
        return turnoService.getTODOS();
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> modificar(@RequestBody TurnoDTO turnoDTO){
        turnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        ResponseEntity response = null;

        if (turnoService.leerTurno(id)== null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            turnoService.eliminarTurno(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return  response;
    }
}
