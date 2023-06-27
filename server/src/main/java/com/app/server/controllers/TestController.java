package com.app.server.controllers;

import com.app.server.repositories.OrderRepository;
import com.app.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping(value = "/register")
    public String register() {
        return "Register page";
    }

    @GetMapping(value = "/auth")
    public String auth() {
        return "auth page";
    }

    @GetMapping(value = "/")
    public ResponseEntity home() {
        return ResponseEntity.ok().body(orderRepository.findById(1L).get());
    }

    @GetMapping(value = "/usr")
    public ResponseEntity usr() {
        return ResponseEntity.ok().body(userRepository.findById(1L));
    }
}
