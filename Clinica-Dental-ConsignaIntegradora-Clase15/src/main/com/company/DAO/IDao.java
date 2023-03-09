package main.com.company.DAO;

public interface IDao  <T> {
        T leer (int id);
        T guardar(T elem);  // aca yo le mando un paciente sin el id y me lo devuelve con el id, porque use el auto incremental en la base de datos
}
