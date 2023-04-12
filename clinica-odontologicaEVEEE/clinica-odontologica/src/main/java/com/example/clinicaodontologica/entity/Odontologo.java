package com.example.clinicaodontologica.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Odontologos")
public class Odontologo {

    @Id
    @SequenceGenerator(name = "odontologo_sequence",sequenceName = "odontologo_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    private Integer id;
    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column(columnDefinition = "VARCHAR(255)")
    private String matricula;

    @OneToMany(mappedBy="odontologo", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Turno> turnos =new HashSet<>();
}
