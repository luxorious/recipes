package com.recipes.controller;

import com.recipes.dto.measureunit.MeasureUnitDTO;
import com.recipes.service.crud.interfaces.MeasureUnitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/measure-unit")
public class MeasureUnitController {

    private final MeasureUnitService service;

    @PostMapping("/create")
    public MeasureUnitDTO create(@Valid @RequestBody MeasureUnitDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/find-all")
    public List<MeasureUnitDTO> findAllMeasureUnits() {
        return service.findAllMeasureUnits();
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteMeasureUnitById(@PathVariable Long id) {
        return service.deleteMeasureUnitById(id);
    }
}
