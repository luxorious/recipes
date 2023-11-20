package com.recipes.controller;

import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.RecipeDTO;
import com.recipes.service.interfaces.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/receipt")
@RequiredArgsConstructor
@Slf4j
public class ReceiptController {

    private final RecipeService receiptService;

    @GetMapping("/get-all")
    public List<RecipeDTO> findAll(){
        return receiptService.findAll();
    }

    @PostMapping("/save")
    public RecipeDTO save(CreateReceiptDTO receiptDTO){
        return receiptService.save(receiptDTO);
    }
}
