package com.app.server.entities;

import com.app.server.entities.pk.AppointmentPK;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_appointments")
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private AppointmentPK id = new AppointmentPK();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Appointment(User user, Organization organization, LocalDateTime date, Order order) {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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

    public LocalDateTime getEnding() {
        Integer total = 0;
        for (OrderItem o : getOrder().getItems()) {
            total += o.getProduct().getDuration() * o.getQuantity();
        }
        return date.plusMinutes(total);
    }
}
