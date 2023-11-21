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
        return mapper.typeMap(Ingredient.class, IngredientDTO.class)
                .addMapping(obj->obj.getQuantity().getId(),
                        (destObjDto, id)->destObjDto.setQuantityId((Long) id))
                .map(entity);
    }

    public Ingredient toEntity(IngredientDTO dto) {
        return mapper.typeMap(IngredientDTO.class, Ingredient.class).
                addMapping(IngredientDTO::getQuantityId,
                        (destObj, id)->destObj.getQuantity().setId((Long) id))
                .map(dto);
    }

    public List<IngredientDTO> toListDTO(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
