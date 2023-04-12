package com.example.clinicaodontologica.dto;

import com.example.clinicaodontologica.entity.Domicilio;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private int dni;
    private LocalDate fecha_ingreso;
    private Domicilio domicilio;

}
