package com.app.server.entities;

import com.app.server.entities.pk.AppointmentPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_appointments")
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private AppointmentPK id = new AppointmentPK();
    private Date date;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Appointment(User user, Organization organization, Date date, Order order) {
        id.setUser(user);
        id.setOrganization(organization);
        this.date = date;
        this.order = order;
    }

    public Appointment() {
    }

    @JsonIgnore
    public User getUser() {
        return id.getUser();
    }

    public Organization getOrganization() {
        return id.getOrganization();
    }

    public void setUser(User user) {
        id.setUser(user);
    }

    public void setOrganization(Organization organization) {
        id.setOrganization(organization);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
