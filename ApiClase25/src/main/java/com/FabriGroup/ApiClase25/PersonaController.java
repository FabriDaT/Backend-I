package com.FabriGroup.ApiClase25;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @PostMapping("/¨{dia}/{mes}/{año}")
    public Persona guardar( Persona persona){
        return new Persona(12,4,94);
    }

}
