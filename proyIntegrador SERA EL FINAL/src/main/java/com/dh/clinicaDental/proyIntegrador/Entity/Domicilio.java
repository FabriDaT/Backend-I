package com.dh.clinicaDental.proyIntegrador.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "domicilios")
@Builder
@Getter
@Setter
public class Domicilio {
    @Id
    @SequenceGenerator(name = "domicilio_sequence",sequenceName = "domicilio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    private Integer id;

    private String calle;

    private int numero;

    private String localidad;

    private String provincia;

    @OneToOne(mappedBy = "domicilio")
    private Paciente paciente;

   
}
