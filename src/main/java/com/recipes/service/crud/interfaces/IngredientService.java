package com.recipes.service.crud.interfaces;

import com.recipes.dto.ingredient.IngredientDTO;

import java.util.List;

public interface IngredientService {

    IngredientDTO create(IngredientDTO dto);

    List<IngredientDTO> findAllIngredients();

    boolean deleteIngredientById(Long id);
}
