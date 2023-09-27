package com.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quantities")
@Data
@NoArgsConstructor
public class Quantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", length = 32)
    private String value;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receipt_id")
    private Recipe recipe;


    @OneToOne(mappedBy = "ingredients")
    private Ingredient ingredient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "measure_units_id")
    private MeasureUnit measureUnit;

}
