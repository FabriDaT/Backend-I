package com.dh.clinicaDental.proyIntegrador.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
@Entity
@Table(name = "odontologos")
public class Odontologo {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;
   // private Set<Paciente> pacientes;
    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore // en relacion 1 a M se recomiendo para evitar bucle infinito
    private Set<Turno> turno;

    public Set<Turno> getTurno() {
        return turno;
    }

    public void setTurno(Set<Turno> turno) {
        this.turno = turno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


}
