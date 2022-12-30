package com.mobile.SpringMobileAPI.service;

import com.mobile.SpringMobileAPI.entity.Client;
import com.mobile.SpringMobileAPI.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    public List<User> getAllUsers();
    public User addOneUser(User user);
    public Optional<User> getOneUser(int id);
    public void deleteOneUser(int id);
}
