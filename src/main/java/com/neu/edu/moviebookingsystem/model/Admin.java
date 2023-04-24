package com.neu.edu.moviebookingsystem.model;

import com.neu.edu.moviebookingsystem.Entities.Movie;

public class Admin extends User{
    public boolean addMovie(Movie movie){
        //TODO Adds movie to database using MovieService
        return  false;
    }

    public boolean addShow(Movie movie){
        //TODO Adds show timings to database
        return false;
    }

    public boolean blockUser(User user){
        return false;
    }
}
