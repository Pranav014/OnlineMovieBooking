package com.neu.edu.moviebookingsystem.controller;

import com.neu.edu.moviebookingsystem.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController {

    private final TheatreService theatreService;


    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }
}
