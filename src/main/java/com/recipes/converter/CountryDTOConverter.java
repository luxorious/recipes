package com.recipes.converter;

import com.recipes.dto.country.CountryDTO;
import com.recipes.entity.Country;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountryDTOConverter {

    private final ModelMapper mapper;

    public CountryDTO toDto(CountryDTO entity) {
        return mapper.map(entity, CountryDTO.class);
    }

    public Country toEntity(CountryDTO dto) {
        return mapper.map(dto, Country.class);
    }


}
