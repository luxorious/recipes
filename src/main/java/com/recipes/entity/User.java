package com.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 64)
    private String firstName;

    @Column(name = "last_name", length = 64)
    private String lastName;

    @Column(name = "e_mail", length = 64)
    private String eMail;

    @Column(name = "about_me", columnDefinition = "TEXT")
    private String aboutMe;

    @Column(name = "skills", columnDefinition = "TEXT")
    private String skills;

    @Column(name = "links", columnDefinition = "TEXT")
    private String links;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;


    @OneToMany(mappedBy = "users", cascade = {MERGE, PERSIST, REFRESH}, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Recipe> recipes;

    @OneToOne(mappedBy = "authentications")
    private Authentication authentication;
}
