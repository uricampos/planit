package com.app.server.entities;

import java.util.*;

public class AppointmentRegister {
    private Date date;
    private List<OrderItem> items = new ArrayList<>();

    public AppointmentRegister() {
    }

    public AppointmentRegister(Date date, List<OrderItem> items) {
        this.date = date;
        this.items = items;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
