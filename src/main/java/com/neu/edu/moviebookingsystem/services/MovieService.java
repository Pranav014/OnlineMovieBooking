package com.neu.edu.moviebookingsystem.services;

import com.neu.edu.moviebookingsystem.DAO.MovieDao;
import com.neu.edu.moviebookingsystem.model.Movie;

import java.util.List;

public class MovieService implements IService<Movie> {


    @Override
    public boolean save(Movie movie) {
        MovieDao mDao = new MovieDao();
        mDao.create(movie);
        return false;
    }


    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Movie> getData() {
        MovieDao mDao = new MovieDao();
        return mDao.getAllData();

    }
}
