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
        return mapper.map(entity, QuantityDTO.class);
    }

    public Quantity toEntity(QuantityDTO dto) {
        return mapper.map(dto, Quantity.class);
    }

    public List<QuantityDTO> toListDTO(List<Quantity> quantities) {
        return quantities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
