package com.recipes.service.crud.interfaces;

import com.recipes.dto.quantity.QuantityDTO;
import com.recipes.entity.Quantity;

import java.util.List;

public interface QuantityService {

    Quantity findById(Long id);

    QuantityDTO create(QuantityDTO dto);

    List<QuantityDTO> findAllQuantities();

    boolean deleteQuantityById(Long id);
}
