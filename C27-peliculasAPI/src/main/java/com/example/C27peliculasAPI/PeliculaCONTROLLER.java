package com.example.C27peliculasAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/pelis")
public class PeliculaCONTROLLER {


    private List<Pelicula> peliculas = new ArrayList<>();

    // Método para buscar todas las películas
    @GetMapping
    public List<PeliculaDTO> buscarPeliculas(List<Pelicula> pelis) {
        List<PeliculaDTO> peliculasDTO = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            PeliculaDTO peliculaDTO = new PeliculaDTO();
            peliculaDTO.setTitulo(pelicula.getTitulo());
            peliculaDTO.setCategoria(pelicula.getCategoria());
            peliculasDTO.add(peliculaDTO);
        }
        return peliculasDTO;
    }

    // Método para eliminar una película por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable Integer id) {
        boolean eliminado = false;
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId().equals(id)) {
                peliculas.remove(pelicula);
                eliminado = true;
                break;
            }
        }
        if (eliminado) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
