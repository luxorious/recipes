package com.recipes.converter.interfaces;

import com.recipes.dto.ingredient.IngredientDTO;
import com.recipes.entity.Ingredient;

import java.util.List;

public interface IngredientDtoConverter {
    IngredientDTO toDto(Ingredient entity);

    Ingredient toEntity(IngredientDTO dto);

    List<IngredientDTO> toListDTO(List<Ingredient> ingredients);
}
