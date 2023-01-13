package com.mobile.SpringMobileAPI.repository;


import com.mobile.SpringMobileAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE user.app_user_id = ?1 ", nativeQuery = true)
    List<User> findByAllByAppUserId(int appUserId);

    Boolean existsByUsername(String username);
}
