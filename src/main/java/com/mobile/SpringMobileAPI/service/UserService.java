package com.mobile.SpringMobileAPI.service;

import com.mobile.SpringMobileAPI.entity.AppUser;
import com.mobile.SpringMobileAPI.entity.User;
import com.mobile.SpringMobileAPI.exception.DataNotFoundException;
import com.mobile.SpringMobileAPI.exception.ForbiddenException;
import com.mobile.SpringMobileAPI.repository.AppUserRepository;
import com.mobile.SpringMobileAPI.repository.UserRepository;
import com.mobile.SpringMobileAPI.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    private final AppUserRepository appUserRepository;

    @Autowired
    public UserService(UserRepository userRepository, AppUserRepository appUserRepository) {
        this.userRepository = userRepository;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public List<User> getAllUsers() {
        AppUser appUser = appUserRepository.findByEmail(SecurityUtil.getloggedUserEmail());
        return userRepository.findByAllByAppUserId(appUser.getId());
    }

    @Override
    public User addOneUser(User user) {
        AppUser appUser = appUserRepository.findByEmail(SecurityUtil.getloggedUserEmail());
        user.setAppUser(appUser);
        user.setCreatedAt(new Date());

        return userRepository.save(user);
    }

    @Override
    public Optional<User> getOneUser(int id) {
        AppUser appUser = appUserRepository.findByEmail(SecurityUtil.getloggedUserEmail());
        Optional<User> user= userRepository.findById(id);
        if (user.isPresent()){
            User existingUser = user.get();
            if (appUser != existingUser.getAppUser()){
                throw new ForbiddenException("You do not have the right to visite this page.");
            }
        } else {
            throw new DataNotFoundException("User with id:"+id+"not found.");
        }
        return user;

    }

    @Override
    public void deleteOneUser(int id) {
        AppUser appUser = appUserRepository.findByEmail(SecurityUtil.getloggedUserEmail());
        Optional<User> user= userRepository.findById(id);
        if (user.isPresent()){
            User existingUser = user.get();
            if (appUser != existingUser.getAppUser()){
                throw new ForbiddenException("You do not have the right to delete this user.");
            }
        } else {
            throw new DataNotFoundException("User with id: "+id+" not found.");
        }
        userRepository.deleteById(id);
    }
}
