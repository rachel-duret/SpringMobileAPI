package com.mobile.SpringMobileAPI.repository;

import com.mobile.SpringMobileAPI.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository <AppUser,Integer>{
    Optional<AppUser> findBy(String email);
}
