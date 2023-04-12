package com.example.clinicaodontologica.repository;

import com.example.clinicaodontologica.entity.Odontologo;
import com.example.clinicaodontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,Integer> {
   /* @Query("Select o from Odontologo o where o.nombre =?1 order by o.name")
    List<Odontologo> findOdontologoByName(String nombre);

    @Query("Select o from Odontologo o where o.matricula=?1")
    Odontologo findOdontologoByMatricula(String matricula);*/

    @Query("Select o from Odontologo o where o.matricula =?1")
    Optional<Odontologo> findOdontoloByMatricula(String matricula);
}
