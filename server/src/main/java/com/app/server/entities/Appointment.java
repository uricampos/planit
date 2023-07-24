package com.app.server.entities;

import com.app.server.entities.pk.AppointmentPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_appointments")
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private AppointmentPK id = new AppointmentPK();
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Appointment(User user, Organization organization, Date date, Order order) {
        id.setOrder(order);
        id.setOrganization(organization);
        this.user = user;
        this.date = date;
    }

    public Appointment() {
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }
    @JsonIgnore
    public Organization getOrganization() {
        return id.getOrganization();
    }

    public void setUser(User user) {
        this.user = user;
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
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, user);
    }
}
