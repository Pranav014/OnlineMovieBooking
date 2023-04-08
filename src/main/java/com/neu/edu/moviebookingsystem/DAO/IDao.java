package com.neu.edu.moviebookingsystem.DAO;

public interface IDao<T> {
    public boolean create(T t);

    public boolean destroy(Long id);
}
