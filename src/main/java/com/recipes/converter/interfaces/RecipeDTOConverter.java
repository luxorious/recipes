package com.recipes.converter.interfaces;

import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.RecipeDTO;
import com.recipes.entity.Recipe;

import java.util.List;

public interface RecipeDTOConverter {
    RecipeDTO toDto(Recipe recipe);

    Recipe toEntity(CreateReceiptDTO dto, String imageName);

    List<RecipeDTO> toListDto(List<Recipe> recipes);
}
