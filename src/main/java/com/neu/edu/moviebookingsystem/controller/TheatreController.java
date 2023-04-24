package com.neu.edu.moviebookingsystem.controller;

import com.neu.edu.moviebookingsystem.Entities.Theatre;
import com.neu.edu.moviebookingsystem.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TheatreController {

    private final TheatreService theatreService;


    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping("/theatres/add")
    public String addTheatre(@RequestBody Theatre theatre){
        //TODO Call service layer to add theatre
        return "Theatre Added";
    }

    @GetMapping("/theatres/getAll")
    public List<Theatre> getTheatres(){
        //TODO Get all values
        return null;//new ArrayList<>(List.of(new Theatre("Dummy","dummy",1L), new Theatre("sdsv","sdvsdv",3l)));


    }

}
