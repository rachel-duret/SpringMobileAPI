package com.mobile.SpringMobileAPI.security;

import com.mobile.SpringMobileAPI.entity.AppUser;
import com.mobile.SpringMobileAPI.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class AppUserSecurityService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with %s not found";
    private AppUserRepository appUserRepository;
    @Autowired
    public AppUserSecurityService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(email);
        if (appUser != null){
            return new User(appUser.getEmail(), appUser.getPassword(), new ArrayList<>());
        } else {
           throw  new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email));
        }

    }


}
