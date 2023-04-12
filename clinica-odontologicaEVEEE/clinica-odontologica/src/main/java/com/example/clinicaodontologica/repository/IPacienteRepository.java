package com.example.clinicaodontologica.repository;

import com.example.clinicaodontologica.dto.PacienteDTO;
import com.example.clinicaodontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Integer> {
     @Query("Select p from Paciente p where p.dni =?1")
     Optional<Paciente> findPacienteByDni(Integer dni);
}
