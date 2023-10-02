package com.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "recipes")
@Data
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 128)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "instruction", columnDefinition = "TEXT")
    private String instruction;

    @Column(name = "cooking_time")
    private Integer cookingTime;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "dish_type", length = 32)
    private String dishType;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;


    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private DishCategory category;

    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(mappedBy = "recipe")
    private Quantity quantity;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "countries_id", referencedColumnName = "id")
    private Country country;
}