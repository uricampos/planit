package com.app.server.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_organizations")
public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Email can't be null")
    private String email;
    @NotBlank(message = "Password can't be null")
    private String password;
    @NotBlank(message = "Name can't be null")
    private String name;
    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "Description can't be null")
    private String description;
    @OneToMany(mappedBy = "id.organization")
    private Set<Appointment> appointments = new HashSet<>();

    @OneToMany(mappedBy = "organization")
    private Set<Product> products = new HashSet<>();

    public Organization() {
    }

    public Organization(Long id, String email, String password, String name, String description) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
