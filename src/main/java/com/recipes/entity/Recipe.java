package com.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "recipes")
@Data
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name", length = 128)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "instructions", columnDefinition = "TEXT")
    private String instructions;

    @Column(name = "cooking_time")
    private Integer cookingTime;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "country", length = 32)
    private String country;

    @Column(name = "dish_type", length = 32)
    private String dishType;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;




    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}


//   private Long id;
//   private Long userId;
//   private String name;
//   private String description;
//   private String instructions;
//   private Integer cookingTime;
//   private Double rating;
//
//   private Long countryId;
//   private Country country;
//
//   private DishType dishType;
//   private Long categoryId;
//   private String imageLink;
//   private Timestamp createdAt;
//}

