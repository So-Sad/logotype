package com.softarex.app.logotype.controller;

import com.softarex.app.logotype.entity.User;
import com.softarex.app.logotype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user";
    }

    @RequestMapping(path = "/users/getOne", method = RequestMethod.GET)
    @ResponseBody
    public Optional<User> getUserById(long id){
        return userService.getUserById(id);
    }

    @RequestMapping(path = "/users/addNew", method = RequestMethod.POST)
    public String addNewUser(User user){
        userService.addNew(user);
        return "redirect:/users";
    }

    @RequestMapping(path = "/sign_up", method = RequestMethod.GET)
    public String signUpUser(Model model){
        model.addAttribute("user", new User());
        return "sign_up";
    }

    @RequestMapping(path = "/sign_up", method = RequestMethod.POST)
    public String signUpUser(@ModelAttribute("user") User user, BindingResult result){
        userService.signNew(user);
        return "redirect:/login";
    }

    @RequestMapping(path = "/users/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateUsers(User user){
        userService.update(user);
        return "redirect:/users";
    }

    @RequestMapping(path = "/users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteUser(long id){
        userService.delete(id);
        return "redirect:/users";
    }

}
