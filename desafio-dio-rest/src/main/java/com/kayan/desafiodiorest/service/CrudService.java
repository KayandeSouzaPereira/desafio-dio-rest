package com.kayan.desafiodiorest.service;

import java.util.List;

public interface CrudService<ID, T>{
    List<T> findall();
    T findByID(ID id);
    T create(T entity);
    T update(ID id, T entity);
    void delete(ID id);
}
