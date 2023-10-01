package com.recipes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quantities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", length = 32)
    private String value;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receipt_id", referencedColumnName = "id")
    private Recipe recipe;

    @OneToOne(mappedBy = "quantity")
    private Ingredient ingredient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "measure_units_id", referencedColumnName = "id")
    private MeasureUnit measureUnit;

}
