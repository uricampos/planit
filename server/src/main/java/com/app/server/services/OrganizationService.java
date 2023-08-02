package com.app.server.services;

import com.app.server.dto.OrganizationDTO;
import com.app.server.dto.OrganizationMinDTO;
import com.app.server.dto.OrganizationRegisterDTO;
import com.app.server.entities.Organization;
import com.app.server.repositories.OrganizationRepository;
import com.app.server.services.exceptions.OrganizationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<OrganizationMinDTO> findAll() {
        return organizationRepository.findAll()
                .stream()
                .map(org -> new OrganizationMinDTO(org))
                .collect(Collectors.toList());
    }

    public OrganizationDTO findById(Long id) {
        return new OrganizationDTO(organizationRepository.findById(id)
                .orElseThrow(() -> new OrganizationNotFoundException("Organization not found.")));
    }

    public OrganizationDTO save(Organization organization) {
        organization.setPassword(passwordEncoder.encode(organization.getPassword()));
        return new OrganizationDTO(organizationRepository.save(organization));
    }

    public Organization findOrganizationById(Long id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new OrganizationNotFoundException("Organization not found."));
    }
}
