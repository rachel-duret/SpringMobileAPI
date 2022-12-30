package com.mobile.SpringMobileAPI.repository;

import com.mobile.SpringMobileAPI.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client,Integer>{
}
