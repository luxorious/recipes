package com.recipes.service.implementation;

import com.recipes.dto.CreateReceiptDTO;
import com.recipes.dto.ReceiptDTO;
import com.recipes.entity.Receipt;
import com.recipes.mapper.ReceiptMapper;
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

    private final ReceiptRepository receiptRepository;
    private final ReceiptMapper receiptMapper;

    @Override
    @Transactional
    public List<Receipt> findAll() {
        return null;
    }

    @Override
    @Transactional
    public ReceiptDTO save(CreateReceiptDTO receiptDTO) {
//        перевірка на рейтинг і всі інші числа щоб були більші нуля
        var receipt = receiptMapper.createDtoToEntity(receiptDTO);
        receiptRepository.save(receipt);
        log.info("receipt saved");
        return receiptMapper.toDto(receipt);
    }
}
