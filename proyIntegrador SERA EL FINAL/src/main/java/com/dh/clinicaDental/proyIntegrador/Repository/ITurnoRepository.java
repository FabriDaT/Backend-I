package com.dh.clinicaDental.proyIntegrador.Repository;

import com.dh.clinicaDental.proyIntegrador.Entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {


}
