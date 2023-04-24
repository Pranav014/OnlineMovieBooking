package com.neu.edu.moviebookingsystem.controller;

import com.neu.edu.moviebookingsystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping("/login")
    public ModelAndView getForm(){
//        HttpSession httpSession =
        System.out.println("IN LOGIN FORM");
        return new ModelAndView("login.html");
    }
    @GetMapping("/registerForm")
    public ModelAndView registerForm(){
        return new ModelAndView("signup.html");
    }
    @PostMapping("/register")
    public ModelAndView registerUser(@RequestBody User user){
        return new ModelAndView("success.html");
    }


}
