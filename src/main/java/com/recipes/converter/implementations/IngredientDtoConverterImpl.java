package com.recipes.converter.implementations;

import com.recipes.converter.interfaces.IngredientDtoConverter;
import com.recipes.dto.ingredient.IngredientDTO;
import com.recipes.entity.Ingredient;
import com.recipes.entity.Quantity;
import com.recipes.service.crud.interfaces.QuantityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class IngredientDtoConverterImpl implements IngredientDtoConverter {

    private final ModelMapper mapper;
    private final QuantityService quantityService;

    @Override
    public IngredientDTO toDto(Ingredient entity) {
        return mapper.typeMap(Ingredient.class, IngredientDTO.class)
                .addMapping(obj -> obj.getQuantity().getId(),
                        (destObjDto, id) -> destObjDto.setQuantityId((Long) id))
                .map(entity);
    }

    @Override
    public Ingredient toEntity(IngredientDTO dto) {
        Ingredient ingredient = mapper.map(dto, Ingredient.class);

        Quantity quantity = quantityService.findById(dto.getQuantityId());
        ingredient.setQuantity(quantity);
        return ingredient;
    }

    @Override
    public List<IngredientDTO> toListDTO(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
