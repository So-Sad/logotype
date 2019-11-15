package com.softarex.app.logotype.controller;

import com.softarex.app.logotype.entity.User;
import com.softarex.app.logotype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public Optional<User> getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }

}
