package com.DH.PatronMVCClase22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PatronMvcClase22Application {

	public static void main(String[] args) {
		SpringApplication.run(PatronMvcClase22Application.class, args);
	}
	@GetMapping("hola")
	public String salaudo(){
		return "hola mundo";
	}

}
