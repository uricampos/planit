package com.app.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping(value = "/register")
    public String register() {
        return "Register page";
    }

    @GetMapping(value = "/auth")
    public String auth() {
        return "auth page";
    }

    @GetMapping(value = "/")
    public String home() {
        return "home page";
    }
}
