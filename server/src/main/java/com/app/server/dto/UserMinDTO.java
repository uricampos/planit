package com.app.server.dto;

import com.app.server.entities.User;

public class UserMinDTO {
    private Long id;
    private String username;
    private String name;

    public UserMinDTO() {
    }

    public UserMinDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
