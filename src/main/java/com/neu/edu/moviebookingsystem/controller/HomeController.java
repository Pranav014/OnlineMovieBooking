package com.neu.edu.moviebookingsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/admin/home")
    public String home(){
        return "Home Page";
    }
    @GetMapping("/admin")
    public String admin(){
        return "Admin Page";
    }
}
