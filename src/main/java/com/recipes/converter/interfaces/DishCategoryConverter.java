package com.recipes.converter.interfaces;

import com.recipes.dto.category.DishCategoryDTO;
import com.recipes.entity.DishCategory;

import java.util.List;

public interface DishCategoryConverter {

    DishCategoryDTO toDto(DishCategory category);

    DishCategory toEntity(DishCategoryDTO dto);

    List<DishCategoryDTO> toListDTO(List<DishCategory> categories);
}
