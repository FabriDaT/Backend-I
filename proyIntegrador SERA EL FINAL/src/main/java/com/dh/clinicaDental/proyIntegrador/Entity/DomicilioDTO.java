package com.dh.clinicaDental.proyIntegrador.Entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DomicilioDTO {

    private String calle;

    private int numero;

    private String localidad;

    private String provincia;
}
