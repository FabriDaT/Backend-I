package com.dh.clinicaDental.proyIntegrador.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table( name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String apellido;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id")
    private Domicilio domicilio;
    private int DNI;
    @OneToMany( mappedBy = "paciente")
    @JsonIgnore    // para que ignore esta propiedad cuando mapee, cuando se pase a json
    private Set<Turno> turno;
    private LocalDate fechaDeAlta;

   // private Odontologo odontologo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Turno> getTurno() {
        return turno;
    }

    public void setTurno(Set<Turno> turno) {
        this.turno = turno;
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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

}
