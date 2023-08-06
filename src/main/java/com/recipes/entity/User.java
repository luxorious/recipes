package com.recipes.entity;

import com.recipes.entity.enumerations.Skills;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 64)
    private String firstName;

    @Column(name = "last_name", length = 64)
    private String lastName;

    @Column(name = "login", length = 64)
    private String login;

    @Column(name = "password", length = 64)
    private String password;

    @Column(name = "e_mail", length = 64)
    private String eMail;

    @Column(name = "about_me")
    private String aboutMe;

    @Column(name = "skills")
    private List<Skills> skills;

    @Column(name = "links")
    private List<String> links;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Receipt> receipts;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
}
