package com.app.server.entities;

import com.app.server.dto.OrganizationRegisterDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_organizations")
public class Organization implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Email can't be null")
    private String username;
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

    public Organization(Long id, String username, String password, String name, String description) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.description = description;
    }

    public Organization(OrganizationRegisterDTO organizationRegisterDTO) {
        this.name = organizationRegisterDTO.getName();
        this.username = organizationRegisterDTO.getUsername();
        this.description = organizationRegisterDTO.getPassword();
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ORG"));
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
