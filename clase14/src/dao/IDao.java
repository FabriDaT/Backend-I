package dao;

public interface IDao <T>{

    public T buscar(long id);
    public T guardar(T t);

}
