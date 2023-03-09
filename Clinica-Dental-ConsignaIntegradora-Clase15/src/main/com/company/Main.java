package main.com.company;

import main.com.company.DAO.impl.PacienteDAOH2;
import main.com.company.model.Domicilio;
import main.com.company.model.Paciente;
import main.com.company.service.PacienteService;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Domicilio domicilio1 = new Domicilio("san luis",1234, "junin","bs as");
        Paciente paciente1 = new Paciente("jose","ruiz","3033494654",LocalDate.now(), domicilio1);




    }
}