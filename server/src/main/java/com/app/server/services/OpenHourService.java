package com.app.server.services;

import com.app.server.entities.OpenHour;
import com.app.server.repositories.OpenHourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenHourService {
    @Autowired
    private OpenHourRepository openHourRepository;

    public OpenHour save(OpenHour openHour) {
        return openHourRepository.save(openHour);
    }
}
