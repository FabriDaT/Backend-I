package com.dh.clinicaDental.proyIntegrador.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table( name = "pacientes")
@Getter
@Builder
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Long id;

    @Setter
    private String nombre;
    @Setter
    private String apellido;

    @Setter
    private int DNI;

    @Setter
    private LocalDate fechaDeIngreso;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_domicilio", nullable = true)
    @JsonIgnore
    @Setter
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }



}
