package io.github.emanuelmcp.productos.api.database.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    void save(T entity);
    void update(T entity);
    long count();
    List<T> findAll();
    T findById(Long id);
}