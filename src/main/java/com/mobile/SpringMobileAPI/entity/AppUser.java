package com.mobile.SpringMobileAPI.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(
        name = "appUser",
        uniqueConstraints = {
                @UniqueConstraint(name = "appUser_email_unique", columnNames = "email")
        }
)

public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;

    @Column(nullable = false, updatable = false, unique = true)
    private String appUsername;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Date createdAt;



//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "app_user_roles", joinColumns = @JoinColumn(name = "app_user_id", referencedColumnName = "id"),
//    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
//    private List<AppUserRole> roles = new ArrayList<>();

    private boolean isActive;
    private boolean isNotLocked;

    public AppUser() {
    }

    public AppUser(int id, String appUsername, String email, String password, Date createdAt,  boolean isActive, boolean isNotLocked) {
        this.id = id;
        this.appUsername = appUsername;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.isActive = isActive;
        this.isNotLocked = isNotLocked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppUsername() {
        return appUsername;
    }

    public void setAppUsername(String appUsername) {
        this.appUsername = appUsername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isNotLocked() {
        return isNotLocked;
    }

    public void setNotLocked(boolean notLocked) {
        isNotLocked = notLocked;
    }
}
