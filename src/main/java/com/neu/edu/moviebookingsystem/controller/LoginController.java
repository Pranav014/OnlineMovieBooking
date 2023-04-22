package com.neu.edu.moviebookingsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
    @GetMapping("/login")
    public ModelAndView getForm(){
//        HttpSession httpSession =
        return new ModelAndView("login.html");
    }
}
