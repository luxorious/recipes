package com.recipes.service.interfaces;

import com.recipes.dto.CreateReceiptDTO;
import com.recipes.dto.ReceiptDTO;

import java.util.List;

public interface ReceiptService {

    List<ReceiptDTO> findAll();

    public ReceiptDTO save(CreateReceiptDTO receiptDTO);
}
