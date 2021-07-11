package com.example.demo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "email")
    String email;

    @Column(name = "full_name")
    String fullName;

    @Column(name = "password")
    String password;
}
