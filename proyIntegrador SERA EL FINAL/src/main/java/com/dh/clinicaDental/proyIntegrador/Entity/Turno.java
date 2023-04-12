package com.dh.clinicaDental.proyIntegrador.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name="turnos")
@Builder
public class Turno {
    @Id
    @SequenceGenerator(name = "turno_sequence",sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long id;
    private LocalDate dia;
    private LocalTime hora;
    @ManyToOne
    @JoinColumn(name = "paciente_id")

    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "odontologo_id")

    private Odontologo odontologo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
}
