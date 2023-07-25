package com.app.server.controllers;

import com.app.server.dto.OrganizationDTO;
import com.app.server.dto.OrganizationMinDTO;
import com.app.server.dto.ProductDTO;
import com.app.server.entities.*;
import com.app.server.repositories.AppointmentRepository;
import com.app.server.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/organizations")
@CrossOrigin(origins = "http://localhost:5173")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private OpenHourService openHourService;

    @Autowired
    private AppointmentRepository appointmentRepository;

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

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "/{id}/appointment")
    public ResponseEntity<Appointment> insertAppointment(@RequestBody AppointmentRegister appointmentRegister, @PathVariable Long id) {
        Organization org = organizationService.findOrganizationById(id);
        User usr = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Order order = orderService.save(new Order(null, usr));
        for (OrderItem item : appointmentRegister.getItems()) {
            item.setOrder(order);
        }
        orderItemService.saveAll(appointmentRegister.getItems().stream().toList());
        Appointment appointment = new Appointment(usr, org, appointmentRegister.getDate(), orderService.findById(order.getId()));
        return ResponseEntity.ok().body(appointmentService.save(appointment));
    }

    @PreAuthorize("hasRole('ROLE_ORG') and principal.id == #id")
    @PostMapping(value = "/{id}/open")
    public ResponseEntity<OpenHour> insertHour(@RequestBody OpenHour openHour, @PathVariable Long id) {
        Organization o = organizationService.findOrganizationById(id);
        openHour.setOrganization(o);
        OpenHour op = openHourService.save(openHour);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(op.getId()).toUri();
        return ResponseEntity.created(uri).body(op);
    }

    @GetMapping(value = "/test")
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }
}
