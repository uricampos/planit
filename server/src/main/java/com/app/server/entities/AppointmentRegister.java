package com.app.server.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.*;

public class AppointmentRegister {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;
    private List<OrderItem> items = new ArrayList<>();

    public AppointmentRegister() {
    }

    public AppointmentRegister(LocalDateTime date, List<OrderItem> items) {
        this.date = date;
        this.items = items;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
