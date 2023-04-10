package com.neu.edu.moviebookingsystem.services;

import java.util.List;

public interface IService<T> {

    public boolean save(T t);

    public boolean delete(Long id);


    List<T> getData();
}
