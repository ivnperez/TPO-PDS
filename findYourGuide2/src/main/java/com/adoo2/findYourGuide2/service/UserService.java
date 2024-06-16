package com.adoo2.findYourGuide2.service;

import com.adoo2.findYourGuide2.model.Usuario;
import com.adoo2.findYourGuide2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Usuario createUser(Usuario usuario) {
        return usuario;
    };

    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    };
}
