package com.recipes.controller;

import com.recipes.dto.measureUnit.MeasureUnitDTO;
import com.recipes.service.interfaces.MeasureUnitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/measure-unit")
public class MeasureUnitController {

    private final MeasureUnitService service;
    @PostMapping("/create")
    public MeasureUnitDTO create(@RequestBody @Valid MeasureUnitDTO dto) {
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
