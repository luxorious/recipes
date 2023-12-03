package com.recipes.service.crud.interfaces;

import com.recipes.dto.measureunit.MeasureUnitDTO;
import com.recipes.entity.MeasureUnit;

import java.util.List;

public interface MeasureUnitService {

    MeasureUnit findById(Long id);

    MeasureUnitDTO create(MeasureUnitDTO dto);

    List<MeasureUnitDTO> findAllMeasureUnits();

    boolean deleteMeasureUnitById(Long id);
}
