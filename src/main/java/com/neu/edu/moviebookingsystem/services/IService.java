package com.neu.edu.moviebookingsystem.services;

import com.neu.edu.moviebookingsystem.model.Movie;

import java.util.List;

public interface IService<T> {

    public boolean save(T t);

    public boolean delete(Long id);


    List<T> getData();

    T update(long id, T t);

    Movie find(long id);
}
