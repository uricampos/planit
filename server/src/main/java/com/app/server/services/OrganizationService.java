package com.app.server.services;

import com.app.server.dto.OrganizationDTO;
import com.app.server.dto.OrganizationMinDTO;
import com.app.server.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public List<OrganizationMinDTO> findAll() {
        return organizationRepository.findAll()
                .stream()
                .map(org -> new OrganizationMinDTO(org))
                .collect(Collectors.toList());
    }

    public OrganizationDTO findById(Long id) {
        return new OrganizationDTO(organizationRepository.findById(id).get());
    }
}
