package com.mobile.SpringMobileAPI.controller;

import com.mobile.SpringMobileAPI.entity.AppUser;
import com.mobile.SpringMobileAPI.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/mobile")
public class AuthController {
    @Autowired
    private AppUserService appUserService;

    @PostMapping("/register")
    public String register(@RequestBody AppUser appUser){
        return null;

    }

//    @PostMapping("/login")
//    public Optional<Client> login(@RequestBody Client client){
//
//    }
}
