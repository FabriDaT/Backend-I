package com.dh.clinicaDental.proyIntegrador.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "domicilios")
public class Domicilio {
    @Id
    @GeneratedValue
    private Long id;
    private String domicilio;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Paciente paciente;



    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
