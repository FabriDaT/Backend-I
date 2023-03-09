package main.com.company.model;

import java.sql.Date;
import java.time.LocalDate;

public class Paciente {

    private Long id;
    private String nombre;
    private  String apellido;
    private String DNI;
    private LocalDate fechaDeIngreso;
    private Domicilio ID_domicilio;

    public Paciente(String nombre, String apellido, String DNI, LocalDate fechaDeIngreso, Domicilio ID_domicilio) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.fechaDeIngreso = fechaDeIngreso;
        this.ID_domicilio = ID_domicilio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public Domicilio getID_domicilio() {
        return ID_domicilio;
    }

    public void setID_domicilio(Domicilio ID_domicilio) {
        this.ID_domicilio = ID_domicilio;
    }
}
