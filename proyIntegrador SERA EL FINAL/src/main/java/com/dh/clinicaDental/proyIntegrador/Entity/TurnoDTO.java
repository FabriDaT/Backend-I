package com.dh.clinicaDental.proyIntegrador.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TurnoDTO {

    private Long id;
    private LocalDate dia;
    private LocalTime hora;
    private Paciente paciente;
    private Odontologo odontologo;


}
