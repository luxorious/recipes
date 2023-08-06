package com.recipes.entity;

import com.recipes.entity.enumerations.Categories;
import com.recipes.entity.enumerations.Countries;
import com.recipes.entity.enumerations.DishType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "receipt")
@NoArgsConstructor
@Data
public class Receipt {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = -1)
    private String description;

    @Column(name = "instruction", length = -1)
    private String instruction;

    @Column(name = "ingredients", length = -1)
    private String ingredients;

    @Column(name = "cooking_time")
    private Long cookingTime;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "country")
    @Enumerated(EnumType.STRING)
    private Countries country;

    @Column(name = "dish_type")
    @Enumerated(EnumType.STRING)
    private DishType dishType;

    @Column(name = "image", length = -1)
    private String imageLink;

    @Column(name = "categories")
    @Enumerated(EnumType.STRING)
    private List<Categories> categories;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Category> categories;


}
