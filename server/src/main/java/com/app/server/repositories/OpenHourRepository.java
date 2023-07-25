package com.app.server.repositories;

import com.app.server.entities.OpenHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenHourRepository extends JpaRepository<OpenHour, Long> {
}
