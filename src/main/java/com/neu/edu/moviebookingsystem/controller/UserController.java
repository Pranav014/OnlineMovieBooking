package com.neu.edu.moviebookingsystem.controller;

import com.neu.edu.moviebookingsystem.model.User;
import com.neu.edu.moviebookingsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/add")
    public String addUser(@RequestBody User user, BindingResult bindingResult, SessionStatus sessionStatus){
//        IService userService = new UserService();
        userService.save(user);
        sessionStatus.setComplete();
        return "User Saved";
    }

    @GetMapping("/users/getAll")
    public List<User> getUser(){
//        IService userService = new UserService();
        return userService.getData();

    }

    @DeleteMapping(value = "/user/delete/{id}")
    public boolean deleteUser(@PathVariable Long id){
//        IService userService = new UserService();
        return userService.delete(id);

    }

    @PutMapping("/users/put/{id}")
    public User updateUser(@PathVariable long id,@RequestBody User user){
//        IService userService = new UserService();
        return (User) userService.update(id, user);

    }

//    @PostMapping("/api/auth/register")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody RegisterRequest request
//    ){
//        return ResponseEntity.ok(authenticationService.register(request));
//        //TODO
//    }
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody AuthenticationRequest request
//    ){
//        return ResponseEntity.ok(authenticationService.authenticate(request));
//    }
//


}
