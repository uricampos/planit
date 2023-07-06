package com.app.server.controllers;

import com.app.server.dto.UserDTO;
import com.app.server.entities.UserLogin;
import com.app.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/register")
    public String register(Model model, UserDTO userDTO) {
        model.addAttribute("user", userDTO);
        return "register";
    }

    @PostMapping(value = "/register")
    public String saveRegister(@ModelAttribute("user") UserDTO userDTO) {
        userService.save(userDTO);
        return "register";
    }

    @GetMapping(value = "/login")
    public String login(Model model, UserLogin userLogin) {
        model.addAttribute("userLogin", userLogin);
        return "login";
    }

    @GetMapping(value = "/home")
    public String home() {
        return "home";
    }
}
