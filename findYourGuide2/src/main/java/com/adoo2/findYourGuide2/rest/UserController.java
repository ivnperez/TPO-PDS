package com.adoo2.findYourGuide2.rest;

import java.util.List;

import com.adoo2.findYourGuide2.model.Guia;
import com.adoo2.findYourGuide2.model.User;
import com.adoo2.findYourGuide2.rest.dto.UserDto;
import com.adoo2.findYourGuide2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // miUrl/users -> lista de usuarios
    @RequestMapping( value ="/users", method = RequestMethod.GET)
    public List<User> getUsers() {
       return userService.getAllUsers();
    };

    @RequestMapping( value ="/users", method = RequestMethod.POST)
    public User createUser(UserDto userDto) {
        User user = new User(userDto.getName());
        return userService.createUser(user);
    };

    @RequestMapping( value ="/guias", method = RequestMethod.GET)
    public List<Guia> getGuias() {
        return null;
    };


}
