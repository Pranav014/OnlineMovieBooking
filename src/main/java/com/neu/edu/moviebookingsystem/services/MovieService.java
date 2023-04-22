package com.neu.edu.moviebookingsystem.services;

import com.neu.edu.moviebookingsystem.DAO.MovieDao;
import com.neu.edu.moviebookingsystem.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class MovieService implements IService<Movie> {

    @Autowired
    private MovieDao movieDao;

    @Override
    public boolean save(Movie movie) {
//        MovieDao mDao = new MovieDao();
        movieDao.create(movie);
        return false;
    }


    @Override
    public boolean delete(Long id) {
        movieDao.destroy(id);
        return false;
    }


    @Override
    public List<Movie> getData() {
//        MovieDao mDao = new MovieDao();
        return movieDao.getAllData();
    }
    @Override
    public Movie update(long id, Movie movie) {
        return movieDao.update(id, movie);
    }

    @Override
    public Movie find(long id){
        return movieDao.find(id);
    }


}
