package com.recipes.converter.interfaces;

import com.recipes.dto.quantity.QuantityDTO;
import com.recipes.entity.Quantity;

import java.util.List;

public interface QuantityDTOConverter {

    QuantityDTO toDto(Quantity entity);

    Quantity toEntity(QuantityDTO dto);

    List<QuantityDTO> toListDTO(List<Quantity> quantities);
}
