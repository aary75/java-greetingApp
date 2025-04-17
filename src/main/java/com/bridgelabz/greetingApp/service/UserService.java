package com.bridgelabz.greetingApp.service;

import com.bridgelabz.greetingApp.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User createUser(String name) {
        User user = new User();
        user.setFirstName(name);
        return user;
    }
}