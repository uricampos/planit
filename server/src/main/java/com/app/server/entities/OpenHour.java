package com.app.server.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "tb_open_hour")
public class OpenHour implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime begin;
    private LocalTime end;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    public OpenHour() {
    }

    public OpenHour(Long id, LocalTime begin, LocalTime end, Organization organization) {
        this.id = id;
        this.begin = begin;
        this.end = end;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getBegin() {
        return begin;
    }

    public void setBegin(LocalTime begin) {
        this.begin = begin;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
