package com.recipes.dto.measureUnit;

import com.recipes.annotation.NullValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasureUnitDTO {
    @NullValidator
    private String unit;
}
