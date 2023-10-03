package com.recipes.dto.quantity;

import com.recipes.annotation.NullValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityDTO {
    @NullValidator
    private String value;
    @NullValidator
    private String unit;
}
