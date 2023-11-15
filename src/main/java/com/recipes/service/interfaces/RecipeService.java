package com.recipes.service.interfaces;

import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.ReceiptDTO;

import java.util.List;

public interface RecipeService {

    List<ReceiptDTO> findAll();

    public ReceiptDTO save(CreateReceiptDTO receiptDTO);
}
