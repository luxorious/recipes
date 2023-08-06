package com.recipes.service.interfaces;

import com.recipes.DTO.CreateReceiptDTO;
import com.recipes.DTO.ReceiptDTO;
import com.recipes.entity.Receipt;

import java.util.List;

public interface ReceiptService {

    List<Receipt> findAll();

    public ReceiptDTO save(CreateReceiptDTO receiptDTO);
}
