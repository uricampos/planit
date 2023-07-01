package com.app.server.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_organizations")
public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name can't be null")
    private String name;
    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "Description can't be null")
    private String description;
    @OneToMany(mappedBy = "id.organization")
    private Set<Appointment> appointments;

    public Organization() {
    }

    public Organization(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
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
