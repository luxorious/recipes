package com.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "dish_categories")
@Data
@NoArgsConstructor
public class DishCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "dish_categories", cascade = {MERGE, PERSIST, REFRESH}, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Recipe> recipes;

}

