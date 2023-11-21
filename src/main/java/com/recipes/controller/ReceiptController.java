package com.recipes.controller;

import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.RecipeDTO;
import com.recipes.service.interfaces.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipt")
@RequiredArgsConstructor
public class ReceiptController {

    private final RecipeService receiptService;

    @GetMapping("/get-all")
    public List<RecipeDTO> findAll() {
        return receiptService.findAll();
    }

    @PostMapping("/save")
    public RecipeDTO save(CreateReceiptDTO receiptDTO) {
        return receiptService.save(receiptDTO);
    }

    @GetMapping("/find-by-country")
    public List<RecipeDTO> findAllByCountry(String country) {
        return receiptService.findAllByCountry(country);
    }

    @GetMapping("/find-by-category")
    public List<RecipeDTO> findAllByCategory(String categoryName) {
        return receiptService.findAllByCategory(categoryName);
    }

    @GetMapping("/find-by-author-full-name")
    public List<RecipeDTO> findAllByFullName(String fullName) {
        return receiptService.findAllByFullName(fullName);
    }

    @GetMapping("/find-by-recipes-name")
    public List<RecipeDTO> findByName(String name) {
        return receiptService.findByName(name);
    }

    @PutMapping("/update-description")
    @ResponseStatus(HttpStatus.OK)
    public void updateDescriptionByName(String name, String description) {
        receiptService.updateDescriptionByName(name, description);
    }

    @PutMapping("/update-instructions")
    @ResponseStatus(HttpStatus.OK)
    public void updateInstructionByName(String name, String instruction) {
        receiptService.updateInstructionByName(name, instruction);
    }

    @PutMapping("/update-dish-type")
    @ResponseStatus(HttpStatus.OK)
    public void updateDishTypeByName(String name, String dishType) {
        receiptService.updateDishTypeByName(name, dishType);
    }

    @PutMapping("/update-image")
    @ResponseStatus(HttpStatus.OK)
    public void updateImagePathByName(String name, String imagePath) {
        receiptService.updateImagePathByName(name, imagePath);
    }

    @PutMapping("/update-cooking-time")
    @ResponseStatus(HttpStatus.OK)
    public void updateCookingTimeByName(String name, Integer cookingTime) {
        receiptService.updateCookingTimeByName(name, cookingTime);
    }

    @PutMapping("/update-name")
    @ResponseStatus(HttpStatus.OK)
    public void updateNameByName(String name, String newName) {
        receiptService.updateNameByName(name, newName);
    }

    @DeleteMapping("/delete-by/name")
    public boolean deleteByNameAndUserId(String name, Long userId) {
        return receiptService.deleteByNameAndUserId(name, userId);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteByIdAndUserId(@PathVariable Long id, @RequestParam Long userId) {
        return receiptService.deleteByIdAndUserId(id, userId);
    }
}
