package com.recipes.service.crud.implementation;

import com.recipes.converter.interfaces.MeasureUnitDTOConverter;
import com.recipes.dto.measureunit.MeasureUnitDTO;
import com.recipes.entity.MeasureUnit;
import com.recipes.repository.MeasureUnitRepository;
import com.recipes.service.crud.interfaces.MeasureUnitService;
import com.recipes.service.nullсhecker.NullChecker;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Data
@Slf4j
@Service
public class MeasureUnitServiceImpl implements MeasureUnitService {

    private final MeasureUnitRepository repository;
    private final MeasureUnitDTOConverter converter;
    private final NullChecker<MeasureUnit> nullChecker;

    //for internal use only
    @Override
    public MeasureUnit findById(Long id) {
        return nullChecker.entity(repository.findById(id));
    }

    @Override
    public MeasureUnitDTO create(MeasureUnitDTO dto) {
        MeasureUnit unit = converter.toEntity(dto);
        return converter.toDto(unit);
    }

    @Override
    public List<MeasureUnitDTO> findAllMeasureUnits() {
        List<MeasureUnit> measureUnits = repository.findAllMeasureUnits();
        return converter.toListDTO(measureUnits);
    }

    @Override
    public boolean deleteMeasureUnitById(Long id) {
        return repository.deleteMeasureUnitById(id);
    }
}
