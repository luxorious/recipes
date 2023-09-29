package com.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "country", length = 64)
    private String country;

    @OneToOne(mappedBy = "country", cascade = {MERGE, PERSIST, REFRESH}, orphanRemoval = true)
    private Recipe recipe;
}
