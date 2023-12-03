package com.recipes.converter.implementations;

import com.recipes.converter.interfaces.MeasureUnitDTOConverter;
import com.recipes.dto.measureunit.MeasureUnitDTO;
import com.recipes.entity.MeasureUnit;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MeasureUnitDTOConverterImpl implements MeasureUnitDTOConverter {
    private final ModelMapper mapper;

    @Override
    public MeasureUnitDTO toDto(MeasureUnit entity) {
        return mapper.map(entity, MeasureUnitDTO.class);
    }

    @Override
    public MeasureUnit toEntity(MeasureUnitDTO dto) {
        return mapper.map(dto, MeasureUnit.class);
    }

    @Override
    public List<MeasureUnitDTO> toListDTO(List<MeasureUnit> measureUnits) {
        return measureUnits.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
