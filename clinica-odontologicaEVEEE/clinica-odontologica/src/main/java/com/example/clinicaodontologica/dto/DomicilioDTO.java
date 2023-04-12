package com.example.clinicaodontologica.dto;

import com.example.clinicaodontologica.entity.Paciente;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DomicilioDTO {
    private Integer id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;
}
