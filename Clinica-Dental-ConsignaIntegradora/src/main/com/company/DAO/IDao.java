package main.com.company.DAO;

public interface IDao <T> {
        T guadar(T paciente);
       T buscar(Long id);
       T modificar(Long id);
       void eliminar(Long id);
       void crear_BD();
}
