package com.app.server.controllers;

import com.app.server.dto.UserDTO;
import com.app.server.entities.Organization;
import com.app.server.entities.UserLogin;
import com.app.server.repositories.OrganizationRepository;
import com.app.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationRepository organizationRepository;


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

    @GetMapping(value = "/home")
    public String home() {
        return "home";
    }

    @GetMapping(value = "/organizations")
    public ResponseEntity<List<Organization>> organizations() {
        return ResponseEntity.ok().body(organizationRepository.findAll());
    }
}
