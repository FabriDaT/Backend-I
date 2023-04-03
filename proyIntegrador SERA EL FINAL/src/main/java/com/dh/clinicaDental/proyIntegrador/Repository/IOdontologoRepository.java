package com.dh.clinicaDental.proyIntegrador.Repository;

import com.dh.clinicaDental.proyIntegrador.Entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {



}
