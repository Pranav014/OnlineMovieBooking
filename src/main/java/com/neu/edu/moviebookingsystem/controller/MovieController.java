package com.neu.edu.moviebookingsystem.controller;

import com.neu.edu.moviebookingsystem.model.Movie;
import com.neu.edu.moviebookingsystem.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@RestController
public class MovieController {

    final
    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

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

    @PutMapping("/movies/put/{id}")
    public String updateMovie(@RequestBody Movie movie, @PathVariable long id){
        movieService.update(id, movie);
        return "Updated";
    }
}
