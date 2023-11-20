package com.recipes.converter;

import com.recipes.dto.measureUnit.MeasureUnitDTO;
import com.recipes.entity.MeasureUnit;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MeasureUnitDTOConverter {
    private final ModelMapper mapper;

    public MeasureUnitDTO toDto(MeasureUnit entity) {
        return mapper.map(entity, MeasureUnitDTO.class);
    }

    public MeasureUnit toEntity(MeasureUnitDTO dto) {
        return mapper.map(dto, MeasureUnit.class);
    }

    public List<MeasureUnitDTO> toListDTO(List<MeasureUnit> measureUnits) {
        return measureUnits.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
