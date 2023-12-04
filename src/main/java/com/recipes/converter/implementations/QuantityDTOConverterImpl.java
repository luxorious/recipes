package com.recipes.converter.implementations;

import com.recipes.converter.interfaces.QuantityDTOConverter;
import com.recipes.dto.quantity.QuantityDTO;
import com.recipes.entity.MeasureUnit;
import com.recipes.entity.Quantity;
import com.recipes.entity.Recipe;
import com.recipes.service.crud.interfaces.MeasureUnitService;
import com.recipes.service.crud.interfaces.RecipeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuantityDTOConverterImpl implements QuantityDTOConverter {

    private final ModelMapper mapper;
    private final MeasureUnitService measureUnitService;
    private final RecipeService recipeService;

    public QuantityDTO toDto(Quantity entity) {
        return mapper.typeMap(Quantity.class, QuantityDTO.class)
                .addMapping(src -> src.getRecipe().getId(),
                        (dest, id) -> dest.setRecipeId((Long) id))
                .addMapping(src -> src.getMeasureUnit().getId(),
                        (dest, id) -> dest.setMeasureUnitsId((Long) id))
                .map(entity);
    }

    public Quantity toEntity(QuantityDTO dto) {
        Quantity quantity = mapper.map(dto, Quantity.class);

        Recipe recipe = recipeService.findById(dto.getRecipeId());
        MeasureUnit measureUnit = measureUnitService.findById(dto.getMeasureUnitsId());
        quantity.setRecipe(recipe);
        quantity.setMeasureUnit(measureUnit);
        return quantity;
    }

    public List<QuantityDTO> toListDTO(List<Quantity> quantities) {
        return quantities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
