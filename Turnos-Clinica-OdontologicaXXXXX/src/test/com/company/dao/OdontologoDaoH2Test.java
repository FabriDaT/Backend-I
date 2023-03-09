package test.com.company.dao;

import main.com.company.dao.IDao;
import main.com.company.dao.impl.OdontologoDaoH2;
import main.com.company.entity.Odontologo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
@RunWith(JUnit4.class)

public class OdontologoDaoH2Test {
    private  static IDao<Odontologo> odontologoDao = new OdontologoDaoH2();

    @BeforeClass
    public static void agregarOdontologos() {
        odontologoDao.agregar(new Odontologo(3L, "OdontologoUno", "NombreUno","MATRI1"));
        odontologoDao.agregar(new Odontologo(4L, "OdontologoDos", "NombreDos","MATRI2"));
        odontologoDao.agregar(new Odontologo(5L, "Odontologores", "NombreTres","MATRI3"));
        odontologoDao.agregar(new Odontologo(6L, "OdontologoCuatro", "NombreCuatro","MATRI4"));
    }

    @Test
    public void listarOdontologosTest(){
        List<Odontologo> odontologos = odontologoDao.listar();
        Assert.assertTrue(odontologos.size() > 0);
    }

}
