package com.dh.clinicaDental.proyIntegrador.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OdontologoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String  matricula;
}
