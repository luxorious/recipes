package com.recipes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "measure_units")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasureUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit", length = 32)
    private String unit;

    @OneToMany(mappedBy = "measureUnit")
    private List<Quantity> quantities;

}
