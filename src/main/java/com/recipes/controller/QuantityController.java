package com.recipes.controller;

import com.recipes.dto.quantity.QuantityDTO;
import com.recipes.service.crud.interfaces.QuantityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/quantities")
public class QuantityController {

    private final QuantityService service;

    @PostMapping("/create")
    public QuantityDTO create(@Valid @RequestBody QuantityDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/find-all")
    public List<QuantityDTO> findAllQuantities() {
        return service.findAllQuantities();
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteQuantityById(@PathVariable Long id) {
        return service.deleteQuantityById(id);
    }
}
