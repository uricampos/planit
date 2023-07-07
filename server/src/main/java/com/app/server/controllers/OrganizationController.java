package com.app.server.controllers;

import com.app.server.dto.OrganizationDTO;
import com.app.server.dto.OrganizationMinDTO;
import com.app.server.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/organizations")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    public ResponseEntity<List<OrganizationMinDTO>> organizations() {
        return ResponseEntity.ok().body(organizationService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrganizationDTO> getOrganizationById(@PathVariable Long id) {
        return ResponseEntity.ok().body(organizationService.findById(id));
    }

}