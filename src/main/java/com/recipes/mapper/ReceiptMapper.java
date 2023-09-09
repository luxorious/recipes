package com.recipes.mapper;

import com.recipes.dto.CreateReceiptDTO;
import com.recipes.dto.ReceiptDTO;
import com.recipes.entity.Receipt;
import com.recipes.entity.Recipe;
import com.recipes.exceptions.ValidationException;

/**
 * interface for mapping between
 * {@link Receipt} entity and {@link ReceiptDTO} DTO.
 */
public interface ReceiptMapper {
    /**
     * Converts a {@link Recipe} entity to a {@link ReceiptDTO} DTO.
     *
     * @param receipt The {@link Recipe} entity to be converted.
     * @return The corresponding {@link ReceiptDTO} DTO.
     */
    ReceiptDTO toDto(Recipe receipt);

    /**
     * Converts a {@link ReceiptDTO} DTO to a {@link Receipt} entity.
     *
     * @param receiptDTO The {@link ReceiptDTO} DTO to be converted.
     * @return The corresponding {@link Receipt} entity.
     * @throws ValidationException If there is a validation error during the conversion.
     */
    Recipe toEntity(ReceiptDTO receiptDTO);

    Recipe createDtoToEntity(CreateReceiptDTO dto);
}
