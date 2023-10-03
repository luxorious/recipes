package com.recipes.dto.country;

import com.recipes.annotation.NullValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
    @NullValidator
    private String country;
}
