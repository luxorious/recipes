package com.recipes.service.interfaces;

import com.recipes.dto.quantity.QuantityDTO;

import java.util.List;

public interface QuantityService {

    QuantityDTO create(QuantityDTO dto);

    List<QuantityDTO> findAllQuantities();

    boolean deleteQuantityById(Long id);
}
