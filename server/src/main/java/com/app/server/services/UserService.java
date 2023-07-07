package com.app.server.services;

import com.app.server.dto.UserDTO;
import com.app.server.entities.User;
import com.app.server.repositories.UserRepository;
import com.app.server.services.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User save(UserDTO userDTO) {
        try {
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            User user = new User(userDTO);
            return userRepository.save(user);
        } catch (Exception e) {
            throw new UserAlreadyExistsException(e.getMessage());
        }
    }
}
