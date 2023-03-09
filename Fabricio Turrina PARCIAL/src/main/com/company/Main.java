package main.com.company;

import main.com.company.dao.impl.OdontologoDaoH2;
import main.com.company.entity.Odontologo;
import main.com.company.service.OdontologoService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {

            Odontologo odontologo1 = new Odontologo(1L,"Torres","Luciana","DHS5456");
            Odontologo odontologo2 = new Odontologo(2L,"Moreno","Mauricio","GH54869");

            OdontologoService odontologoService = new OdontologoService();
            odontologoService.setOdontologoDao(new OdontologoDaoH2());
            odontologoService.createDB();

            odontologoService.agregarOdontologo(odontologo1);
            odontologoService.agregarOdontologo(odontologo2);


            System.out.println("\n-----------ODONTOLOGOS-----------\n");
            for (int i = 0; i < odontologoService.listarOdontologos().size(); i++) {

                System.out.println("Odontologo "+odontologoService.listarOdontologos().get(i).getId()+
                                " | "+ odontologoService.listarOdontologos().get(i).getApellido() + " "+
                                odontologoService.listarOdontologos().get(i).getNombre() + " - Matricula: "+
                                odontologoService.listarOdontologos().get(i).getMatricula() + "\n"
                        );
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}