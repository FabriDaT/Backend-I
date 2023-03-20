package com.example.C27peliculasAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class C27PeliculasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(C27PeliculasApiApplication.class, args);

		Pelicula p1 = new Pelicula("The Shawshank Redemption", "Drama", 7, 4);
		Pelicula p2 = new Pelicula("La La Land", "Musical", 6, 1);

		//Creamos una lista de películas para hacer operaciones sobre ella//
		List<Pelicula> listaPeliculas = new ArrayList<>();
		listaPeliculas.add(p1);
		listaPeliculas.add(p2);



		ObjectMapper mapper = new ObjectMapper();
		PeliculaDTO peliculaDTO = mapper.convertValue(p1,PeliculaDTO.class);
		PeliculaCONTROLLER controller = new PeliculaCONTROLLER();
		controller.buscarPeliculas(listaPeliculas);

	}

}
