package dao;

import java.util.List;

public interface Persistencia<T> {

    int create (T obj);
    List<T> read();
    boolean update (T obj);
    boolean delete (T obj);
    T findByCodigo (int id);

}
