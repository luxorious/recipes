package com.recipes.service.implementation;

import com.recipes.converter.DishCategoryConverter;
import com.recipes.dto.category.DishCategoryDTO;
import com.recipes.entity.DishCategory;
import com.recipes.repository.DishCategoryRepository;
import com.recipes.service.interfaces.DishCategoryService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Data
@Slf4j
@Service
public class DishCategoryServiceImpl implements DishCategoryService {
    private final DishCategoryRepository repository;
    private final DishCategoryConverter converter;
    @Override
    public DishCategoryDTO create(DishCategoryDTO dto) {
        DishCategory category = converter.toEntity(dto);
        return converter.toDto(category);
    }

    @Override
    public List<DishCategoryDTO> findAllCategories() {
        List<DishCategory> categories = repository.findAllCategories();
        return converter.toListDTO(categories);
    }

    @Override
    public boolean deleteCategoryById(Long id) {
        return repository.deleteCategoryById(id);
    }
}
