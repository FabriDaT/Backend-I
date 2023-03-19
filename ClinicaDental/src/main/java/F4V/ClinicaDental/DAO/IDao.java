package F4V.ClinicaDental.DAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IDao <T>{

    T guardar(T t);
    T buscar(int id);
    void eliminar(int id);
    void actualizar(T t);
    List<T> buscarTodos();


}
