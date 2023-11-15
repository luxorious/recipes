package com.recipes.service.implementation;

import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.ReceiptDTO;
import com.recipes.mapper.RecipeDTOConverter;
import com.recipes.repository.ReceiptRepository;
import com.recipes.service.interfaces.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private final ReceiptRepository repository;
    private final RecipeDTOConverter converter;

    @Override
    @Transactional
    public List<ReceiptDTO> findAll() {
        return null;
    }

    @Override
    @Transactional
    public ReceiptDTO save(CreateReceiptDTO receiptDTO) {
        repository.save(converter.toEntity(receiptDTO));
        log.info("receipt saved");
        return null;
    }
}
