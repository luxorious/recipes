package com.recipes.controller;

import com.recipes.dto.country.CountryDTO;
import com.recipes.service.interfaces.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
