package com.sintad.techtest.security.auth.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.sintad.techtest.security.auth.model.User;
import com.sintad.techtest.security.auth.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}