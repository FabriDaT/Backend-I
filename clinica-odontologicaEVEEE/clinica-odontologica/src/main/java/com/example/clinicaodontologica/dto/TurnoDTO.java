package com.example.clinicaodontologica.dto;

import com.example.clinicaodontologica.entity.Odontologo;
import com.example.clinicaodontologica.entity.Paciente;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TurnoDTO {
    private Integer id;
    private LocalDateTime fecha_hora;
    private PacienteDTO paciente;
    private OdontologoDTO odontologo;
}
