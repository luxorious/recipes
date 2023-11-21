package com.recipes.dto.quantity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityDTO {

    private String value;
    private String unit;
    private Long recipeId;
    private Long measureUnitsId;

}
