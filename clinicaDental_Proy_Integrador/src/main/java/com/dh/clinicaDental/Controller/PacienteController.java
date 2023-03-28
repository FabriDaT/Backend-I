package com.dh.clinicaDental.Controller;

import com.dh.clinicaDental.Dao.impl.PacienteDaoH2;
import com.dh.clinicaDental.Model.Paciente;
import com.dh.clinicaDental.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
        pacienteService.setPacienteIdao(new PacienteDaoH2());
    }


    public Paciente agregar(@RequestBody Paciente paciente){
     return pacienteService.agregar(paciente);
    }

}
