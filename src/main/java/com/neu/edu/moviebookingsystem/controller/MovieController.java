package com.neu.edu.moviebookingsystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.edu.moviebookingsystem.Entities.Movie;
import com.neu.edu.moviebookingsystem.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@RestController
public class MovieController {
    final
    MovieService movieService;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movies/add")
    public ResponseEntity<String> addMovie(@RequestBody String json, BindingResult bindingResult, SessionStatus sessionStatus){
        try {
            Movie movie = objectMapper.readValue(json, Movie.class);
            // Do something with the movie object
            movieService.save(movie);
            sessionStatus.setComplete();
            return ResponseEntity.ok("Movie created successfully");
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().body("Invalid JSON format" + e.getMessage());
        }

    }

    @GetMapping("/movie")
    public List<Movie> getMovie(){
        return movieService.getData();
    }

    @PutMapping("/movies/put/{id}")
    public ResponseEntity<String> updateMovie(@RequestBody String json, @PathVariable long id, SessionStatus sessionStatus){
        try {
            Movie movie = objectMapper.readValue(json, Movie.class);
            // Do something with the movie object
            movieService.update(id, movie);
            sessionStatus.setComplete();
            return ResponseEntity.ok("Movie Updated successfully");
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().body("Invalid JSON format" + e.getMessage());
        }

    }

    @PostMapping("/movies/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable long id, SessionStatus sessionStatus){
        // Do something with the movie object
        movieService.delete(id);
        sessionStatus.setComplete();
        return ResponseEntity.ok("Movie deleted successfully");

    }
}
