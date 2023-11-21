package com.recipes.converter;

import com.recipes.dto.quantity.QuantityDTO;
import com.recipes.entity.Quantity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuantityDTOConverter {
    private final ModelMapper mapper;

    public QuantityDTO toDto(Quantity entity) {
        return mapper.typeMap(Quantity.class, QuantityDTO.class)
                .addMapping(src -> src.getRecipe().getId(),
                        (dest, id)-> dest.setRecipeId((Long) id))
                .addMapping(src->src.getMeasureUnit().getId(),
                        (dest, id)->dest.setMeasureUnitsId((Long) id))
                .map(entity);
    }

    public Quantity toEntity(QuantityDTO dto) {
        return mapper.typeMap(QuantityDTO.class, Quantity.class)
                .addMapping(QuantityDTO::getRecipeId,
                        (destObj, id)->destObj.getRecipe().setId((Long) id))
                .addMapping(QuantityDTO::getMeasureUnitsId,
                        (destObj, id)->destObj.getMeasureUnit().setId((Long) id))
                .map(dto);
    }

    public List<QuantityDTO> toListDTO(List<Quantity> quantities) {
        return quantities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
