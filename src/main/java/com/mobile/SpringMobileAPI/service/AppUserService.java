package com.mobile.SpringMobileAPI.service;

import com.mobile.SpringMobileAPI.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "User with %s not found";
    private AppUserRepository appUserRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findBy(email)
                .orElseThrow(()->
                        new UsernameNotFoundException(
                            String.format(USER_NOT_FOUND, email)
                ));
    }
}
