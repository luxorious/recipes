package com.recipes.converter.interfaces;

import com.recipes.dto.country.CountryDTO;
import com.recipes.entity.Country;

import java.util.List;

public interface CountryDTOConverter {

    CountryDTO toDto(Country entity);

    Country toEntity(CountryDTO dto);

    List<CountryDTO> toListDto(List<Country> countries);
}
