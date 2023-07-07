package com.app.server.controllers;

import com.app.server.dto.UserDTO;
import com.app.server.entities.UserLogin;
import com.app.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public void saveRegister(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
    }

    @GetMapping(value = "/login")
    public void login(Model model, UserLogin userLogin) {
        model.addAttribute("userLogin", userLogin);
    }
}
