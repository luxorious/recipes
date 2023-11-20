package com.recipes.converter;

import com.recipes.dto.category.DishCategoryDTO;
import com.recipes.entity.DishCategory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DishCategoryConverter {

    private final ModelMapper mapper;

    public DishCategoryDTO toDto(DishCategory category){
        return mapper.map(category, DishCategoryDTO.class);
    }

    public DishCategory toEntity(DishCategoryDTO dto){
        return mapper.map(dto, DishCategory.class);
    }

    public List<DishCategoryDTO> toListDTO(List<DishCategory> categories) {
        return categories.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
