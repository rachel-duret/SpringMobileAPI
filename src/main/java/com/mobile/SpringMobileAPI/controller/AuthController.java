package com.mobile.SpringMobileAPI.controller;

import com.mobile.SpringMobileAPI.dto.AuthResponseDto;
import com.mobile.SpringMobileAPI.dto.LoginDto;
import com.mobile.SpringMobileAPI.dto.RegisterDto;
import com.mobile.SpringMobileAPI.entity.AppUser;
import com.mobile.SpringMobileAPI.repository.AppUserRepository;
import com.mobile.SpringMobileAPI.security.AppUserSecurityService;
import com.mobile.SpringMobileAPI.security.jwt.JwtGenerator;
import com.mobile.SpringMobileAPI.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private AppUserSecurityService appUserSecurityService;
    private AppUserService appUserService;
    private AppUserRepository appUserRepository;

    private JwtGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          PasswordEncoder passwordEncoder,
                          AppUserSecurityService appUserSecurityService,
                          AppUserService appUserService,
                          JwtGenerator jwtGenerator,
                          AppUserRepository appUserRepository) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.appUserSecurityService = appUserSecurityService;
        this.appUserService = appUserService;
        this.jwtGenerator = jwtGenerator;
        this.appUserRepository = appUserRepository;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
//        if(appUserService.existsByEmail(registerDto.getEmail())== true){
//            return new ResponseEntity<>("Email exist .", HttpStatus.BAD_REQUEST);
//        }



        AppUser appUser = new AppUser();
        appUser.setAppUsername(registerDto.getUsername());
        appUser.setEmail(registerDto.getEmail());
        appUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        appUser.setActive(false);
        appUser.setCreatedAt(new Date());
        appUser.setNotLocked(true);

        appUserRepository.save(appUser);

        return new ResponseEntity<>("User registered success!", HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){

        UsernamePasswordAuthenticationToken usernamePasswordAuthentication =
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());
//        Authentication Manager will take this token try to find the user then
       Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(jwtToken, HttpStatus.OK);
    }
}
