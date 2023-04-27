package com.neu.edu.moviebookingsystem.controller;

import com.neu.edu.moviebookingsystem.Entities.Movie;
import com.neu.edu.moviebookingsystem.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {


    final MovieService movieService;

    public AdminController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/admin/movies/add")
    public String getAddMovieFormPage(){
        return "addMovies.html";
    }

    @GetMapping("/admin/dashboard")
    public String getDashboard(Model model){
        List<Movie> movies = movieService.getData();
        model.addAttribute("movies", movies);
        return "adminDashboard.html";
    }



}
