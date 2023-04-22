package com.neu.edu.moviebookingsystem.DAO;

import com.neu.edu.moviebookingsystem.model.Movie;

import java.util.List;

public interface IMovieDAO {
    boolean create(Movie movie);

    boolean destroy(Long id);

    List<Movie> getAllData();

    Movie update(long id, Movie movie);

    boolean find(Long id);




}
