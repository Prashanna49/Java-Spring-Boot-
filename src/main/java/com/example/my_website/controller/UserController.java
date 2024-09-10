package com.example.my_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.my_website.Model.User;

@Controller
public class UserController {

    @GetMapping("/")
    public String showLoginForm(Model model){
        model.addAttribute("user", new User());
        return "index"; 
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
        // Simulated login logic
        if ("admin".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            model.addAttribute("message", "Welcome, " + user.getUsername());
            return "home"; // Go to home page
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
}


