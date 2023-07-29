package com.app.server.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.LocalTime;

@Entity
@Table(name = "tb_open")
public class OpenHour implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime beginHour;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime endHour;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    public OpenHour() {
    }

    public OpenHour(Long id, LocalTime beginHour, LocalTime endHour, Organization organization) {
        this.id = id;
        this.beginHour = beginHour;
        this.endHour = endHour;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(LocalTime beginHour) {
        this.beginHour = beginHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }

    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }

    @JsonIgnore
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
