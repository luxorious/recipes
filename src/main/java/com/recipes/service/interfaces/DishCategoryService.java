package com.recipes.service.interfaces;

import com.recipes.dto.category.DishCategoryDTO;

import java.util.List;

public interface DishCategoryService {
    DishCategoryDTO create(DishCategoryDTO dto);

    List<DishCategoryDTO> findAllCategories();

    boolean deleteCategoryById(Long id);
}
