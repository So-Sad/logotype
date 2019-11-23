package com.softarex.app.logotype.service;

import com.softarex.app.logotype.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllUsers();
    public Optional<User> getUserById(long id);
    public void addNew(User user);
    public void update(User user);
    public void delete(long id);

}
