package com.app.server.controllers;

import com.app.server.dto.OrganizationDTO;
import com.app.server.dto.OrganizationMinDTO;
import com.app.server.dto.ProductDTO;
import com.app.server.entities.Organization;
import com.app.server.entities.Product;
import com.app.server.services.OrganizationService;
import com.app.server.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/organizations")
@CrossOrigin(origins = "http://localhost:5173")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<OrganizationMinDTO>> organizations() {
        return ResponseEntity.ok().body(organizationService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrganizationDTO> getOrganizationById(@PathVariable Long id) {
        return ResponseEntity.ok().body(organizationService.findById(id));
    }

    @PreAuthorize("hasRole('ROLE_ORG') and principal.id == #id")
    @PostMapping(value = "/{id}/add")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product, @PathVariable Long id) {
        Organization o = organizationService.findOrganizationById(id);
        product.setOrganization(o);
        ProductDTO p = productService.save(product);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}/add")
                .buildAndExpand(p.getId())
                .toUri();
        return ResponseEntity.created(uri).body(p);
    }
}
