package com.recipes.service.crud.implementation;

import com.recipes.converter.interfaces.QuantityDTOConverter;
import com.recipes.dto.quantity.QuantityDTO;
import com.recipes.entity.Quantity;
import com.recipes.repository.QuantityRepository;
import com.recipes.service.crud.interfaces.QuantityService;
import com.recipes.service.nullсhecker.NullChecker;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Data
@Slf4j
@Service
public class QuantityServiceImpl implements QuantityService {
    private final QuantityRepository repository;
    private final QuantityDTOConverter converter;
    private final NullChecker<Quantity> nullChecker;

    @Override
    public Quantity findById(Long id) {
        return nullChecker.entity(repository.findById(id));
    }

    @Override
    public QuantityDTO create(QuantityDTO dto) {
        Quantity quantity = converter.toEntity(dto);
        return converter.toDto(quantity);
    }

    @Override
    public List<QuantityDTO> findAllQuantities() {
        List<Quantity> quantities = repository.findAllQuantities();
        return converter.toListDTO(quantities);
    }

    @Override
    public boolean deleteQuantityById(Long id) {
        return repository.deleteQuantityById(id);
    }
}
