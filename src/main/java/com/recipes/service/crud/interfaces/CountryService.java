package com.recipes.service.crud.interfaces;

import com.recipes.dto.country.CountryDTO;
import com.recipes.entity.Country;

import java.util.List;

public interface CountryService {

    Country findById(Long id);

    CountryDTO create(CountryDTO dto);

    List<CountryDTO> getByCountryName(String countryName);

    boolean deleteCountryById(Long id);
}
