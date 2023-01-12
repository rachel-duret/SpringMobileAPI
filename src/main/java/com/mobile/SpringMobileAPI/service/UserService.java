package com.mobile.SpringMobileAPI.service;

import com.mobile.SpringMobileAPI.entity.AppUser;
import com.mobile.SpringMobileAPI.entity.User;
import com.mobile.SpringMobileAPI.repository.AppUserRepository;
import com.mobile.SpringMobileAPI.repository.UserRepository;
import com.mobile.SpringMobileAPI.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;
    private AppUserRepository appUserRepository;

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
        return userRepository.findById(id);
    }

    @Override
    public void deleteOneUser(int id) {
        userRepository.deleteById(id);
    }
}
