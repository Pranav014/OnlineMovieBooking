package com.neu.edu.moviebookingsystem.controller;

import com.neu.edu.moviebookingsystem.Entities.User;
import com.neu.edu.moviebookingsystem.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    final private UserService userService;

    final private PasswordEncoder passwordEncoder;

    public LoginController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public ModelAndView getForm(Model model){
//        HttpSession httpSession =
        System.out.println("IN LOGIN FORM");
//        ModelAndView mav = new ModelAndView();
        User user = new User();
        model.addAttribute("user");
        return new ModelAndView("login.html", "user",user);
    }
    @GetMapping("/register")
    public ModelAndView registerForm(){
        return new ModelAndView("signup.html");
//        return new ModelAndView("adminDashboard.html");
    }
    @PostMapping("/register")
    public ModelAndView registerUser(@RequestParam("username") String username, @RequestParam("firstName") String firstName,
                                     @RequestParam("lastName") String lastName, @RequestParam("password") String password){

        System.out.println("IN REGISTER POST");

        User user = new User();
        user.setFirstName(firstName);
        user.setUsername(username);
        user.setLastName(lastName);
        user.setPassword(passwordEncoder.encode(password));
        user.setActive((byte) 1);
        user.setRoles("ROLE_USER");
        userService.save(user);
        return new ModelAndView("successRegister.html","username", user.getUsername());
    }

}
