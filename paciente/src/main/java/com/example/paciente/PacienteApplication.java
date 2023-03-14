package com.example.paciente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@SpringBootApplication

public class PacienteApplication {

	public static void main(String[] args) {

		SpringApplication.run(PacienteApplication.class, args);

	}
	@GetMapping("/")  				// asi podemos NO escribir nada despues de tipear localhost:8080 en el navegador
	public String holaPaciente(){
		return "holaPaciente... como estas hoy dia?";
	}


}
