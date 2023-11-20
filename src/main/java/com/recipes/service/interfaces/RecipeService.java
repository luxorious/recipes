package com.recipes.service.interfaces;

import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.RecipeDTO;

import java.util.List;

public interface RecipeService {

    List<RecipeDTO> findAll();

    public RecipeDTO save(CreateReceiptDTO receiptDTO);
}
