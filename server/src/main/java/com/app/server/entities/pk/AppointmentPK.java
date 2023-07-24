package com.app.server.entities.pk;

import com.app.server.entities.Order;
import com.app.server.entities.Organization;
import com.app.server.entities.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AppointmentPK implements Serializable {
    private static final long serialVersionUID = 1L;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    public AppointmentPK() {
    }

    public AppointmentPK(Order order, Organization organization) {
        this.order = order;
        this.organization = organization;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentPK that = (AppointmentPK) o;
        return Objects.equals(order, that.order) && Objects.equals(organization, that.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, organization);
    }
}
