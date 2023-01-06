package com.mobile.SpringMobileAPI.repository;

import com.mobile.SpringMobileAPI.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository <AppUser,Integer>{
         Optional<AppUser> findByEmail(String email);
         Boolean existsByEmail(String email);
}
