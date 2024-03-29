package com.dh.clinicaDental.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
    private LocalDate fecha;
    private LocalTime hora;

    public Turno(LocalDate fecha, LocalTime hora) {
        this.fecha = fecha;
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
