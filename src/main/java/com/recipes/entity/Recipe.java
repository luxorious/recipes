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

    @Column(name = "user_id")
    private Long userId;

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

    @Column(name = "category_id")
    private Long categoryId;

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

    @OneToOne(mappedBy = "quantities")
    private Quantity quantity;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "countries_id")
    private Country country;
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

