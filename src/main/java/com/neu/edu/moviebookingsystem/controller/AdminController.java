package com.neu.edu.moviebookingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/movies/add")
    public String getAddMovieFormPage(){
        return "addMovies.html";
    }
}
