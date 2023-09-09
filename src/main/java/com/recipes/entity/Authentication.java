package com.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authentications")
@Data
@NoArgsConstructor
public class Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role")
    private String role;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

}

