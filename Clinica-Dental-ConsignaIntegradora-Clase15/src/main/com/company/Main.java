package main.com.company;

import main.com.company.DAO.impl.PacienteDAOH2;
import main.com.company.model.Domicilio;
import main.com.company.model.Paciente;
import main.com.company.service.PacienteService;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Paciente paciente1 = new Paciente(1L,"pepito","gonzalez","123456", Date.valueOf(LocalDate.now()),new Domicilio(1L,"mendoza",2134,"trinidad","san juan") );
        Domicilio domi1 = new Domicilio(2L,"Av Mendoza", 1220,"trinidad", "san juan");
        // creamos el service y seteamos estrategia
        PacienteService ps = new PacienteService(new PacienteDAOH2());
        ps.crear_DB();
        ps.guardar(paciente1);
    }
}