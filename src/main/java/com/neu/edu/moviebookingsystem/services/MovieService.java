package com.neu.edu.moviebookingsystem.services;

import com.neu.edu.moviebookingsystem.DAO.MovieDao;
import com.neu.edu.moviebookingsystem.model.Movie;

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
}
