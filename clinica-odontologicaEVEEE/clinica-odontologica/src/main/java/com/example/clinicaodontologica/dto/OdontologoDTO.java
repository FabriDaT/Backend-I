package com.example.clinicaodontologica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OdontologoDTO {
    private Integer id;
    private String apellido;
    private String nombre;
    private String matricula;
}
