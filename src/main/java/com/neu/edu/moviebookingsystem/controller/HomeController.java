package com.neu.edu.moviebookingsystem.controller;

import com.neu.edu.moviebookingsystem.Entities.User;
import com.neu.edu.moviebookingsystem.services.MovieService;
import com.neu.edu.moviebookingsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    final
    MovieService movieService;

    final UserService userService;

    @Autowired
    public HomeController(MovieService movieService, UserService userService) {
        this.movieService = movieService;
        this.userService = userService;
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

    @GetMapping("/profile")
    public ModelAndView getProfile(HttpServletRequest request, HttpServletResponse response, Model model){
        ModelAndView mav = new ModelAndView("profile.html");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        HttpSession session = request.getSession();
//        User u = (User) auth.getPrincipal();
        System.out.println(auth.getDetails());
        User u = userService.findByUsername(auth.getName());
        System.out.println("BEFORE SETTING SESSION " + u.getUsername());
        session.setAttribute("user", u);
        mav.addObject("user", u);

        return mav;
    }
}
