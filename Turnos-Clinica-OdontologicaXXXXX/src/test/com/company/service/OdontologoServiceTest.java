package test.com.company.service;

import main.com.company.dao.IDao;
import main.com.company.dao.impl.OdontologoDaoEnMemoria;
import main.com.company.dao.impl.OdontologoDaoH2;
import main.com.company.entity.Odontologo;
import main.com.company.service.OdontologoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)

public class OdontologoServiceTest {

    private IDao<Odontologo> odontologoDaoEnMemoria = new OdontologoDaoEnMemoria(new ArrayList());
    private IDao<Odontologo> odontologoDaoH2 = new OdontologoDaoH2();
    private OdontologoService odontologoService = new OdontologoService();

    @Before
    public void agregarOdontologosCambiandoImplementacionDao(){
        //En este caso odontologoDao estará apuntando a un objeto del tipo OdontologoDaoEnMemoria
        odontologoService.setOdontologoDao(odontologoDaoEnMemoria);
        //Siguiendo el principio de polimorfismo el método guardar se comportará de acuerdo al comportamiento indicado en la clase EstudianteDaoEnMemoria
        odontologoService.agregarOdontologo(new Odontologo(1L, "ApellidoUno", "NombreUno","MATRI1"));

        //En este caso odontologoDao estará apuntando a un objeto del tipo odontologoDaoH2
        odontologoService.setOdontologoDao(odontologoDaoH2);
        //Siguiendo el principio de polimorfismo el método buscar se comportará de acuerdo al comportamiento indicado en la clase OdontologoDaoEnMemoria
        odontologoService.agregarOdontologo(new Odontologo(3L, "ApellidoDos", "NombreDos","MATRI2"));

        //Conclusión el método agregar se comporta diferente de acuerdo al objeto que estamos referenciando en cada momento.

    }

    @Test
    public void listarOdontologosCambiandoImplementacionDAO(){
        //En este caso odontologoDao estará apuntando a un objeto del tipo OdontologoDaoEnMemoria
        odontologoService.setOdontologoDao(odontologoDaoEnMemoria);
        //Siguiendo el principio de polimorfismo el método listar se comportará de acuerdo al comportamiento indicado en la clase OdontologoDaoEnMemoria
        List<Odontologo> odontologos = odontologoService.listarOdontologos();
        Assert.assertTrue(odontologos.size() > 0);

        //En este caso odontologoDao estará apuntando a un objeto del tipo OdontologoDaoH2
        odontologoService.setOdontologoDao(odontologoDaoH2);
        //Siguiendo el principio de polimorfismo el método listar se comportará de acuerdo al comportamiento indicado en la clase OdontologoDaoH2
        odontologos = odontologoService.listarOdontologos();
        Assert.assertTrue(odontologos.size() > 0);

        //Conclusión el método listar se comporta diferente de acuerdo al objeto que estamos referenciando en cada momento.

    }


}
