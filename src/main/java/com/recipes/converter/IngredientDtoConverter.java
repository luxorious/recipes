package com.recipes.converter;

import com.recipes.dto.ingredient.IngredientDTO;
import com.recipes.entity.Ingredient;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class IngredientDtoConverter {
    private final ModelMapper mapper;

    public IngredientDTO toDto(Ingredient entity) {
        return mapper.map(entity, IngredientDTO.class);
    }

    public Ingredient toEntity(IngredientDTO dto) {
        return mapper.map(dto, Ingredient.class);
    }

    public List<IngredientDTO> toListDTO(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
