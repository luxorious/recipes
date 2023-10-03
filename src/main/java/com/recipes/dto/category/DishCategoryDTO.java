package com.recipes.dto.category;

import com.recipes.annotation.NullValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishCategoryDTO {
    @NullValidator
    private String categoryName;
}
