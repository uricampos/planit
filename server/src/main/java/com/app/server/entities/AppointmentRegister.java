package com.app.server.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.*;

public class AppointmentRegister {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mmz")
    private LocalDateTime start;
    private List<OrderItem> items = new ArrayList<>();

    public AppointmentRegister() {
    }

    public AppointmentRegister(LocalDateTime date, List<OrderItem> items) {
        this.start = date;
        this.items = items;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setDate(LocalDateTime start) {
        this.start = start;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
