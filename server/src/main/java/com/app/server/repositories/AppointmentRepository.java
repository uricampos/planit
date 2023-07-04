package com.app.server.repositories;

import com.app.server.entities.Appointment;
import com.app.server.entities.pk.AppointmentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentPK> {
}
