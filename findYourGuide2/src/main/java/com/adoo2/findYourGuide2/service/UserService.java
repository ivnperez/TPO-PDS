package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.factory.StateFactory;
import com.adoo2.findYourGuide2.model.User;
import com.adoo2.findYourGuide2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return user;
    };

    public List<User> getAllUsers() {
        return userRepository.findAll();
    };
}
