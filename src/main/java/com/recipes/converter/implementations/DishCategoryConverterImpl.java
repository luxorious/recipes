package com.recipes.converter.implementations;

import com.recipes.converter.interfaces.DishCategoryConverter;
import com.recipes.dto.category.DishCategoryDTO;
import com.recipes.entity.DishCategory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DishCategoryConverterImpl implements DishCategoryConverter {

    private final ModelMapper mapper;

    @Override
    public DishCategoryDTO toDto(DishCategory category) {
        return mapper.map(category, DishCategoryDTO.class);
    }

    @Override
    public DishCategory toEntity(DishCategoryDTO dto) {
        return mapper.map(dto, DishCategory.class);
    }

    @Override
    public List<DishCategoryDTO> toListDTO(List<DishCategory> categories) {
        return categories.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
