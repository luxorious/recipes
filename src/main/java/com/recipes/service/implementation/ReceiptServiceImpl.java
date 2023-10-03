package com.recipes.service.implementation;

import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.ReceiptDTO;
import com.recipes.mapper.RecipeDTOConverter;
import com.recipes.repository.ReceiptRepository;
import com.recipes.service.interfaces.ReceiptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReceiptServiceImpl implements ReceiptService {

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
//        перевірка на рейтинг і всі інші числа щоб були більші нуля
        log.info("receipt saved");
        return null;
    }
}
