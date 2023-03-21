package F4V.ClinicaDental.Controller;

import F4V.ClinicaDental.DAO.Impl.PacienteDaoH2;
import F4V.ClinicaDental.Model.Paciente;
import F4V.ClinicaDental.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class PacienteController {

    private PacienteService pacienteService = null;

    public PacienteController() {
       // pacienteService.setPacienteIDao(new PacienteDaoH2());
        this.pacienteService = new PacienteService(new PacienteDaoH2());
    }

    @PostMapping("/")
    public Paciente guardar(@RequestBody Paciente paciente){

        return pacienteService.guardar(paciente);
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable("id") int id){
        return pacienteService.buscar(id);
    }

    @GetMapping("/")
    public List<Paciente> buscarTodos(){
        return pacienteService.buscarTodos();
    }

    @PutMapping("/")
    public void actualizar(@RequestBody Paciente paciente){
        pacienteService.actualizar(paciente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        pacienteService.eliminar(id);
    }

}
