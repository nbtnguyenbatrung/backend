package com.huce.manege.entity;

import javax.persistence.*;

@Entity
@Table(name = "API_KEY")
public class ApiKeyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private long id;

    @Column(name = "KEY", nullable = false)
    private String key;

    @Column(name = "USERNAME" , nullable = false )
    private String username;

    @Column(name = "PASSWORD" , nullable = false )
    private String password;

    @Column(name = "ROLE" , nullable = false )
    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
