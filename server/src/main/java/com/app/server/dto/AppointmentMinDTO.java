package com.app.server.dto;

import com.app.server.entities.Appointment;

import java.util.Date;

public class AppointmentMinDTO {
    private Date date;

    public AppointmentMinDTO() {
    }

    public AppointmentMinDTO(Appointment appointment) {
        this.date = appointment.getDate();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
