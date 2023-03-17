package F4V.ClinicaDental.Controller;

import F4V.ClinicaDental.DAO.Impl.PacienteDaoH2;
import F4V.ClinicaDental.Model.Paciente;
import F4V.ClinicaDental.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PacienteController {

    private PacienteService pacienteService;


    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
        pacienteService.setPacienteIDao(new PacienteDaoH2());
    }

    @PostMapping("/")
    public Paciente guardar(@RequestBody Paciente paciente){
        return pacienteService.guardar(paciente);
    }


}
