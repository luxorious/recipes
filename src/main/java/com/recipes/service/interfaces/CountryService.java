package com.recipes.service.interfaces;

import com.recipes.dto.country.CountryDTO;

import java.util.List;

public interface CountryService {

    CountryDTO create(CountryDTO dto);

    List<CountryDTO> getByCountryName(String countryName);

    boolean deleteCountryById(Long id);
}
