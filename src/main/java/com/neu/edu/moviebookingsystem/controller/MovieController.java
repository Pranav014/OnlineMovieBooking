package com.neu.edu.moviebookingsystem.controller;

import com.neu.edu.moviebookingsystem.model.Movie;
import com.neu.edu.moviebookingsystem.services.MovieService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@RestController
public class MovieController {

    @PostMapping("/movie/add")
    public String addMovie(@RequestBody Movie movie, BindingResult bindingResult, SessionStatus sessionStatus){
        MovieService movieService = new MovieService();
        movieService.save(movie);
        sessionStatus.setComplete();
        return "Movie Saved";
    }

    @GetMapping("/movie")
    public List<Movie> getMovie(){
        MovieService movieService = new MovieService();
        return movieService.getData();

    }
}
