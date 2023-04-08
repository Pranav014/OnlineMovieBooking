package com.neu.edu.moviebookingsystem.services;

public interface IService<T> {

    public boolean save(T t);

    public boolean delete(Long id);


}
