package com.mobile.SpringMobileAPI.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(
        name = "client",
        uniqueConstraints = {
                @UniqueConstraint(name = "client_email_unique", columnNames = "email")
        }
)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false, updatable = false, unique = true)
    private int id;

    @Column(nullable = false, updatable = false, unique = true)
    private String clientName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Date createdAt;
}
