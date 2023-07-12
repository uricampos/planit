package com.app.server.controllers;

import com.app.server.dto.*;
import com.app.server.entities.OrgLogin;
import com.app.server.entities.Organization;
import com.app.server.entities.User;
import com.app.server.entities.UserLogin;
import com.app.server.services.OrganizationService;
import com.app.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserMinDTO> saveUserRegister(@RequestBody UserDTO userDTO) {
        UserMinDTO user = new UserMinDTO(userService.save(userDTO));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @PostMapping(value = "/register/org")
    public ResponseEntity<OrganizationMinDTO> saveOrgRegister(@RequestBody OrganizationRegisterDTO organizationRegisterDTO) {
        OrganizationMinDTO org = new OrganizationMinDTO(organizationService.save(organizationRegisterDTO));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(org.getId())
                .toUri();
        return ResponseEntity.created(uri).body(org);
    }

    @GetMapping(value = "/login")
    public void login(Model model, UserLogin userLogin) {
        model.addAttribute("userLogin", userLogin);
    }

    @GetMapping(value = "/login-success")
    public ResponseEntity<User> loginSuccessful() {
        return ResponseEntity.ok().body((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    @GetMapping(value = "/login/org")
    public void orgLogin(Model model, OrgLogin orgLogin) {
        model.addAttribute("orgLogin", orgLogin);
    }

    @GetMapping("/org-login-success")
    public ResponseEntity<OrganizationMinDTO> orgLoginSuccessful() {
        return ResponseEntity.ok().body(new OrganizationMinDTO((Organization) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }
}
