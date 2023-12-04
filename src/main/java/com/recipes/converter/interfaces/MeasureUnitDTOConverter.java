package com.recipes.converter.interfaces;

import com.recipes.dto.measureunit.MeasureUnitDTO;
import com.recipes.entity.MeasureUnit;

import java.util.List;

public interface MeasureUnitDTOConverter {

    MeasureUnitDTO toDto(MeasureUnit entity);

    MeasureUnit toEntity(MeasureUnitDTO dto);

    List<MeasureUnitDTO> toListDTO(List<MeasureUnit> measureUnits);
}
