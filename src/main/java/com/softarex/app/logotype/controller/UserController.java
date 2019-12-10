package com.softarex.app.logotype.controller;

import com.softarex.app.logotype.entity.User;
import com.softarex.app.logotype.service.UserService;
import com.softarex.app.logotype.util.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private UserService userService;
    private EmailSender emailSender;

    @Autowired
    public UserController(UserService userService, EmailSender emailSender) {
        this.userService = userService;
        this.emailSender = emailSender;
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user";
    }

    @RequestMapping(path = "/users/getOne", method = RequestMethod.GET)
    @ResponseBody
    public Optional<User> getUserById(long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(path = "/users/getByEmail", method = RequestMethod.GET)
    @ResponseBody
    public User getCurrentUserByEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = "";
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        return userService.getUserByEmail(currentUserName);
    }

    @RequestMapping(path = "/users/addNew", method = RequestMethod.POST)
    public String addNewUser(User user) {
        userService.addNew(user);
        return "redirect:/users";
    }

    @RequestMapping(path = "/sign_up", method = RequestMethod.GET)
    public String signUpUser(Model model) {
        model.addAttribute("user", new User());
        return "sign_up";
    }

    @RequestMapping(path = "/sign_up", method = RequestMethod.POST)
    public String signUpUser(@ModelAttribute("user") User user, BindingResult result) {
        userService.signNew(user);
        emailSender.sendSignUpEmail(user.getEmail());
        return "redirect:/login";
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    @RequestMapping(path = "/editProfile", method = RequestMethod.GET)
    public String editUser() {
        return "edit_profile";
    }

    @RequestMapping(path = "/editProfile", method = RequestMethod.POST)
    public String editUser(User user) {
        userService.update(user);
        emailSender.sendChangePasswordEmail(user.getEmail());
        return "redirect:/success";
    }

    @RequestMapping(path = "/users/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateUsers(User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @RequestMapping(path = "/users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteUser(long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
