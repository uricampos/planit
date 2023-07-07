package com.app.server.controllers;

import com.app.server.dto.UserDTO;
import com.app.server.entities.UserLogin;
import com.app.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/register")
    public void register(Model model, UserDTO userDTO) {
        model.addAttribute("user", userDTO);
    }

    @PostMapping(value = "/register")
    public void saveRegister(@ModelAttribute("user") UserDTO userDTO) {
        userService.save(userDTO);
    }

    @GetMapping(value = "/login")
    public void login(Model model, UserLogin userLogin) {
        model.addAttribute("userLogin", userLogin);
    }
}
