package com.recipes.service.crud.implementation;

import com.recipes.converter.interfaces.DishCategoryConverter;
import com.recipes.dto.category.DishCategoryDTO;
import com.recipes.entity.DishCategory;
import com.recipes.repository.DishCategoryRepository;
import com.recipes.service.crud.interfaces.DishCategoryService;
import com.recipes.service.nullchecker.NullChecker;
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
    private final NullChecker<DishCategory> checker;

    @Override
    public DishCategory findById(Long id) {
        return checker.entity(repository.findById(id));
    }

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
