package com.app.server.dto;

import com.app.server.entities.Appointment;

import java.time.LocalDateTime;
import java.util.Date;

public class AppointmentMinDTO {
    private LocalDateTime date;
    private LocalDateTime ending;

    public AppointmentMinDTO() {
    }

    public AppointmentMinDTO(Appointment appointment) {
        this.date = appointment.getDate();
        this.ending = appointment.getEnding();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
