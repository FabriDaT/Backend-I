package com.dh.clinicaDental.proyIntegrador.Repository;

import com.dh.clinicaDental.proyIntegrador.Entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, Long> {


}
