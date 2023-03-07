package daos;

import java.sql.SQLException;

public interface IDao<T> {
  public void createDB();
  public void guardar(T t) throws SQLException, ClassNotFoundException;
  public T buscarXNombre(String Nombre);
  public T buscarXId(long id);
  
}
