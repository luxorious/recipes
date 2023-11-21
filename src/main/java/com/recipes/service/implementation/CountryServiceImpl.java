package com.recipes.service.implementation;

import com.recipes.converter.CountryDTOConverter;
import com.recipes.dto.country.CountryDTO;
import com.recipes.entity.Country;
import com.recipes.repository.CountryRepository;
import com.recipes.service.interfaces.CountryService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Data
@Slf4j
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;
    private final CountryDTOConverter converter;
    @Override
    public CountryDTO create(CountryDTO dto) {
        Country country = converter.toEntity(dto);
        return converter.toDto(country);
    }

    @Override
    public List<CountryDTO> getByCountryName(String countryName) {
        List<Country> countries = repository.findByName(countryName);
        return converter.toListDto(countries);
    }

    @Override
    public boolean deleteCountryById(Long id) {
        return repository.deleteCountryById(id);
    }
}
