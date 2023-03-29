package com.dh.clinicaDental.proyIntegrador.Repository;

import com.dh.clinicaDental.proyIntegrador.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {





}
