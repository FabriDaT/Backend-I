package com.FabriGroup.ApiClase25;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {

    public static void main(String[] args) {
        SpringApplication.run(ApiClase25Application.class, args);
    }


    @GetMapping("/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        Period edad = Period.between(fechaNacimiento, fechaActual);
        return  edad.getYears();
    }
}
