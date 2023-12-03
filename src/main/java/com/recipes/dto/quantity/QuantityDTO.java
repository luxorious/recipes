package com.recipes.dto.quantity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityDTO {

    @NotBlank
    @NotNull
    private String value;

    @NotBlank
    @NotNull
    private String unit;

    @Min(1)
    private Long recipeId;

    @Min(1)
    private Long measureUnitsId;

}
