package com.mobile.SpringMobileAPI.service;

import com.mobile.SpringMobileAPI.dto.RegisterDto;
import com.mobile.SpringMobileAPI.entity.AppUser;
import com.mobile.SpringMobileAPI.entity.Product;
import com.mobile.SpringMobileAPI.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AppUserService {

    private AppUserRepository appUserRepository;


    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public boolean existsByEmail(String email){
        return  appUserRepository.existsByEmail(email);
    }

    public AppUser addOneUser(AppUser appUser){
        return  appUserRepository.save(appUser);

    }

}
