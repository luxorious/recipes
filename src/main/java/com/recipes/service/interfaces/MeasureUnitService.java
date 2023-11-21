package com.recipes.service.interfaces;

import com.recipes.dto.measureUnit.MeasureUnitDTO;

import java.util.List;

public interface MeasureUnitService {

    MeasureUnitDTO create(MeasureUnitDTO dto);

    List<MeasureUnitDTO> findAllMeasureUnits();

    boolean deleteMeasureUnitById(Long id);
}
