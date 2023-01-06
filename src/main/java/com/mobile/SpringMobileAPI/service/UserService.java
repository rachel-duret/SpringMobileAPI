package com.mobile.SpringMobileAPI.service;

import com.mobile.SpringMobileAPI.entity.User;
import com.mobile.SpringMobileAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addOneUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getOneUser(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteOneUser(int id) {
        userRepository.deleteById(id);
    }
}
