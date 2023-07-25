package com.app.server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_open")
public class OpenHour implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date beginHour;
    private Date endHour;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    public OpenHour() {
    }

    public OpenHour(Long id, Date beginHour, Date endHour, Organization organization) {
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

    public Date getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(Date beginHour) {
        this.beginHour = beginHour;
    }

    public Date getEndHour() {
        return endHour;
    }

    public void setEndHour(Date endHour) {
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
