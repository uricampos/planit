package com.app.server.dto;

import com.app.server.entities.Appointment;
import com.app.server.entities.OpenHour;
import com.app.server.entities.Organization;
import com.app.server.entities.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrganizationDTO {
    private Long id;
    private String username;
    private String name;
    private String description;
    private List<AppointmentMinDTO> appointments = new ArrayList<>();
    private Set<ProductDTO> products = new HashSet<>();

    private Set<OpenHour> openHours = new HashSet<>();

    public OrganizationDTO() {
    }

    public OrganizationDTO(Organization organization) {
        this.id = organization.getId();
        this.username = organization.getUsername();
        this.name = organization.getName();
        this.description = organization.getDescription();
        this.appointments = minimizeAppointments(organization.getAppointments());
        this.products = minimizeProducts(organization.getProducts());
        this.openHours = organization.getOpenHours();
    }

    private List<AppointmentMinDTO> minimizeAppointments(Set<Appointment> appointments) {
        return appointments.stream()
                .map(appointment -> new AppointmentMinDTO(appointment))
                .collect(Collectors.toList());
    }

    private Set<ProductDTO> minimizeProducts(Set<Product> products) {
        return products.stream()
                .map(product -> new ProductDTO(product))
                .collect(Collectors.toSet());
    }

    public Set<OpenHour> getOpenHours() {
        return openHours;
    }

    public Set<ProductDTO> getProducts() {
        return products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AppointmentMinDTO> getAppointments() {
        return appointments;
    }
}
