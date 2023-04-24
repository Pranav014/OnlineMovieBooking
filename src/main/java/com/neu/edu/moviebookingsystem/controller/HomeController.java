package com.neu.edu.moviebookingsystem.controller;

import com.neu.edu.moviebookingsystem.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    final
    MovieService movieService;

    @Autowired
    public HomeController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/home")
    public ModelAndView home(Model model){
        ModelAndView mav = new ModelAndView("home.html");
        mav.addObject("messages", movieService.getData());
        return mav;
    }
    @GetMapping("/hello")
    public ModelAndView hello(){
        return new ModelAndView("hello.html");
    }
}
