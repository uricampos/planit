package com.app.server.services;

import com.app.server.dto.UserDTO;
import com.app.server.entities.User;
import com.app.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(UserDTO userDTO) {
        User user = new User(userDTO);
        return userRepository.save(user);
    }
}
