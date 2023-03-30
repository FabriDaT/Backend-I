package com.dh.clinicaDental.proyIntegrador.Service;


import com.dh.clinicaDental.proyIntegrador.Entity.Paciente;
import com.dh.clinicaDental.proyIntegrador.Entity.PacienteDTO;
import com.dh.clinicaDental.proyIntegrador.Repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class PacienteService implements  IPacienteService{

    @Autowired
    private IPacienteRepository PacienteRepository;
    @Autowired
    ObjectMapper mapper;  // clase de la biblioteca Jackson, que se utiliza para convertir objetos Java en formato JSON y viceversa, para enviar respuestas HTTP en formato JSON
    private void guardarPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO , Paciente.class);
        PacienteRepository.save(paciente);
    }

    @Override
    public void crearPaciente(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);
    }

    @Override
    public PacienteDTO leerPaciente(Long id) {
        Optional<Paciente> paciente =  PacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if (paciente.isPresent())
            pacienteDTO =  mapper.convertValue(paciente, PacienteDTO.class);
        return pacienteDTO;
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);
    }

    @Override
    public void eliminarPaciente(Long id) {
        PacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDTO> getTODOS() {
        List<Paciente> pacientes =  PacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();

        for (Paciente paciente: pacientes){
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return  pacientesDTO;
    }


}
