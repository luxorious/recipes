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

    @Column(name = "receipt_id")
    private Long receiptId;

    @Column(name = "measure_units_id")
    private long measureUnitsId;


    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "measure_units_id")
    private MeasureUnit measureUnit;

}
