package com.example.gestionRdv.entities;


import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="utilisateur",
uniqueConstraints ={
        @UniqueConstraint(columnNames = "username" +""),
        @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String fullname;

    private String email;
    private String password;
    private String phone;
    private boolean isActive;

    private String role;
   /* @OneToMany(mappedBy = "user")
    private Collection<Appointment> appointments;
  */
    public User() {
    }

    public User(Long id, String username, String email, String password, boolean isActive, String role,String phone,String fullname) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.role = role;
        this.phone= phone;
        this.fullname=fullname;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
