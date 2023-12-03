package com.recipes.converter.implementations;

import com.recipes.converter.interfaces.CountryDTOConverter;
import com.recipes.dto.country.CountryDTO;
import com.recipes.entity.Country;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CountryDTOConverterImpl implements CountryDTOConverter {

    private final ModelMapper mapper;

    @Override
    public CountryDTO toDto(Country entity) {
        return mapper.map(entity, CountryDTO.class);
    }

    @Override
    public Country toEntity(CountryDTO dto) {
        return mapper.map(dto, Country.class);
    }

    @Override
    public List<CountryDTO> toListDto(List<Country> countries) {
        return countries.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
