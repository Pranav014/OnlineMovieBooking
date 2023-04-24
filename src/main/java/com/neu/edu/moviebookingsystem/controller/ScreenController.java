package com.neu.edu.moviebookingsystem.controller;

import com.neu.edu.moviebookingsystem.services.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScreenController {

    @Autowired
    final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @GetMapping("/screens/getshow/{id}")
    public List<String> getSeats(@PathVariable String id){
        long Id = Long.parseLong(id);
        List<String> result = screenService.getShows(Id);
//        Screens[] arr = result.toArray(new Screens[result.size()]);
        return result;

    }
}
