package com.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ingredients")
@Data
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 128)
    private String name;

    @Column(name = "quantity_id")
    private Long quantityId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quantity_id")
    private Quantity quantity;

}
