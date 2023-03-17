package com.dh.clinicaDental.Services;

import com.dh.clinicaDental.Dao.Idao;
import com.dh.clinicaDental.Model.Paciente;

import java.util.List;

public class PacienteService implements Idao<Paciente> {

    private Idao<Paciente> pacienteIdao;

    public PacienteService(Idao<Paciente> pacienteIdao) {
        this.pacienteIdao = pacienteIdao;
    }

    public Idao<Paciente> getPacienteIdao() {
        return pacienteIdao;
    }

    public void setPacienteIdao(Idao<Paciente> pacienteIdao) {
        this.pacienteIdao = pacienteIdao;
    }

    @Override
    public List listar() {
        return null;
    }

    @Override
    public Paciente agregar(Paciente elem) {
        return null;
    }

    @Override
    public Paciente modificar(Paciente elem) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }
}
