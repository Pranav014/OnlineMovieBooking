package com.neu.edu.moviebookingsystem.services;

import com.neu.edu.moviebookingsystem.DAO.MovieDao;
import com.neu.edu.moviebookingsystem.Entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class MovieService implements IService<Movie> {

    private final MovieDao movieDao;

    @Autowired
    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public boolean save(Movie movie) {
//        MovieDao mDao = new MovieDao();
        Movie m = findByName(movie.getMovieName());
        if (m != null){
            return false;
        }
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

    public Movie findByName(String name){
        return movieDao.findByName(name);
    }


}
