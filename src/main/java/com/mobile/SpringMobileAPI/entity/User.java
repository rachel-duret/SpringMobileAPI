package com.mobile.SpringMobileAPI.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(unique = true, nullable = false, updatable = false)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false, updatable = false, name = "client_id")
    private int clientId;
}
