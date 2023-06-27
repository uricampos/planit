package com.app.server.repositories;

import com.app.server.entities.Appointment;
import com.app.server.entities.pk.AppointmentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentPK> {
}
