package com.neu.edu.moviebookingsystem.controller;

import com.neu.edu.moviebookingsystem.Entities.Ticket;
import com.neu.edu.moviebookingsystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    final
    MovieService movieService;

    final UserService userService;


    final BookingService bookingService;


    final ShowService showService;


    final ScreenService screenService;



    @Autowired
    public BookController(MovieService movieService, UserService userService, BookingService bookingService, ShowService showService, ScreenService screenService) {
        this.movieService = movieService;
        this.userService = userService;
        this.bookingService = bookingService;
        this.showService = showService;
        this.screenService = screenService;
    }

    @GetMapping("/book")
    public ModelAndView bookForm(){
        ModelAndView mav = new ModelAndView("book.html");
        // Date and movie should come from show

        mav.addObject("shows", showService.getShows());
        return mav;
    }

    @PostMapping("/book")
    public ModelAndView bookMovie(@RequestParam("checkboxes") List<String> checkboxes, @RequestParam("movie") long show_Id){
        ModelAndView mav = new ModelAndView("booked.html");
        System.out.println(checkboxes);
        System.out.println(show_Id);

        Ticket ticket = bookingService.bookTicket(show_Id, checkboxes);
        mav.addObject("ticket", ticket);
//        mav.addObject("movies", movieService.getData());
        return mav;
    }
}
