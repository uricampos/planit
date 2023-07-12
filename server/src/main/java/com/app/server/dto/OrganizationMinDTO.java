package com.app.server.dto;

import com.app.server.entities.Organization;

public class OrganizationMinDTO {
    private Long id;
    private String username;
    private String description;
    private String name;

    public OrganizationMinDTO() {
    }

    public OrganizationMinDTO(Organization organization) {
        this.id = organization.getId();
        this.username = organization.getUsername();
        this.description = organization.getDescription();
        this.name = organization.getName();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
