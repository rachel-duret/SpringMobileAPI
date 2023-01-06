package com.mobile.SpringMobileAPI.repository;

import com.mobile.SpringMobileAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Boolean existsByUsername(String username);
}
