package com.neu.edu.moviebookingsystem.DAO;

import java.util.List;

public interface IDao<T> {
    public boolean create(T t);

    public boolean destroy(Long id);

    public List<T> getAllData();
}
