package com.app.server.controllers;

import com.app.server.dto.UserDTO;
import com.app.server.dto.UserMinDTO;
import com.app.server.entities.User;
import com.app.server.entities.UserLogin;
import com.app.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/auth", method = RequestMethod.POST)
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserMinDTO> saveRegister(@RequestBody UserDTO userDTO) {
        UserMinDTO user = new UserMinDTO(userService.save(userDTO));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @GetMapping(value = "/login")
    public void login(Model model, UserLogin userLogin) {
        model.addAttribute("userLogin", userLogin);
    }

    @GetMapping(value = "/login-success")
    public ResponseEntity<User> loginSuccessful() {
        return ResponseEntity.ok().body((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
