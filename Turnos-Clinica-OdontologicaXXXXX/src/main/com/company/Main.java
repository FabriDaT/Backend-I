package main.com.company;

import main.com.company.dao.IDao;
import main.com.company.dao.impl.OdontologoDaoH2;
import main.com.company.entity.Odontologo;
import main.com.company.service.OdontologoService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            Odontologo odontologo1 = new Odontologo(1L,"Pepito","Turiini", "54fgf8rdf");
            Odontologo odontologo2 = new Odontologo(2L,"Laura","Andrada","54ddf5f");

            OdontologoService odontologoService = new OdontologoService();
            odontologoService.setOdontologoIDao(new OdontologoDaoH2());
            odontologoService.crearBD();
            odontologoService.agregarOdontologo(odontologo1);
            odontologoService.agregarOdontologo(odontologo2);
            odontologoService.ListarOdontologos();

        }catch (Exception e){
            System.out.println(e.getMessage() + "sql error");
        }

    }
}