package com.recipes.service.crud.interfaces;

import com.recipes.dto.category.DishCategoryDTO;
import com.recipes.entity.DishCategory;

import java.util.List;

public interface DishCategoryService {

    DishCategory findById(Long id);

    DishCategoryDTO create(DishCategoryDTO dto);

    List<DishCategoryDTO> findAllCategories();

    boolean deleteCategoryById(Long id);
}
