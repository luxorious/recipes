package com.recipes.controller;

import com.recipes.DTO.CreateReceiptDTO;
import com.recipes.DTO.ReceiptDTO;
import com.recipes.entity.Receipt;
import com.recipes.service.interfaces.ReceiptService;
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

    private final ReceiptService receiptService;

    @GetMapping("/get-all")
    public List<Receipt> findAll(){
        return receiptService.findAll();
    }

    @PostMapping("/save")
    public ReceiptDTO save(CreateReceiptDTO receiptDTO){
        return receiptService.save(receiptDTO);
    }
}
