package com.neu.edu.moviebookingsystem.controller;

import com.neu.edu.moviebookingsystem.model.User;
import com.neu.edu.moviebookingsystem.services.IService;
import com.neu.edu.moviebookingsystem.services.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@RestController
public class UserController {
    @PostMapping("/user/add")
    public String addMovie(@RequestBody User user, BindingResult bindingResult, SessionStatus sessionStatus){
        IService userService = new UserService();
        userService.save(user);
        sessionStatus.setComplete();
        return "User Saved";
    }

    @GetMapping("/user/getAll")
    public List<User> getUser(){
        IService userService = new UserService();
        return userService.getData();

    }
}
