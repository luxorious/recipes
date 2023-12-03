package com.recipes.controller;

import com.recipes.dto.country.CountryDTO;
import com.recipes.service.crud.interfaces.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    @PostMapping("/create")
    public CountryDTO create(@Valid @RequestBody CountryDTO dto) {
        return countryService.create(dto);
    }

    @GetMapping("/find-by-name")
    List<CountryDTO> getByCountryName(@RequestParam String countryName) {
        return countryService.getByCountryName(countryName);
    }

    @DeleteMapping("/delete/{id}")
    boolean deleteCountryById(@PathVariable Long id) {
        return countryService.deleteCountryById(id);
    }
}
