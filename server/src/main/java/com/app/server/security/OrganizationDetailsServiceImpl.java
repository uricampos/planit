package com.app.server.security;

import com.app.server.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OrganizationDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return organizationRepository
                .findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("No user found."));
    }
}
