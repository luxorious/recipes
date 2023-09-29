package com.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "measure_units")
@Data
@NoArgsConstructor
public class MeasureUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit", length = 32)
    private String unit;

    @OneToOne(mappedBy = "measureUnit")
    private Quantity quantity;

}
