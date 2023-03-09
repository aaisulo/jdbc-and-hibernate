package pl.sda.orange2.dao;

import java.sql.SQLException;
import java.util.List;

public interface DataAccess<E, ID> {
    void save(E car);

    List<E> findAll();

    E findById(ID id) throws SQLException;

    void deleteById(ID id);
}