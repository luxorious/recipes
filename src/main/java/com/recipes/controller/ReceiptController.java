package com.recipes.controller;

import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.RecipeDTO;
import com.recipes.service.crud.interfaces.RecipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class ReceiptController {

    private final RecipeService receiptService;

    @GetMapping("/get-all")
    public List<RecipeDTO> findAll() {
        return receiptService.findAll();
    }

    @PostMapping("/save")
    public RecipeDTO save(
            @Valid @RequestPart CreateReceiptDTO receiptDTO,
            @RequestPart MultipartFile file ) {

        return receiptService.save(receiptDTO, file);
    }

    @GetMapping("/find-by-country")
    public List<RecipeDTO> findAllByCountry(@RequestParam  String country)   {
        return receiptService.findAllByCountry(country);
    }

    @GetMapping("/find-by-category")
    public List<RecipeDTO> findAllByCategory(@RequestParam String categoryName)  {
        return receiptService.findAllByCategory(categoryName);
    }

    @GetMapping("/find-by-author-full-name")
    public List<RecipeDTO> findAllByAuthorsFullName(@RequestParam String fullName){
        return receiptService.findAllByAuthorsFullName(fullName);
    }

    @GetMapping("/find-by-recipes-name")
    public List<RecipeDTO> findByName(@RequestParam String name){
        return receiptService.findByRecipeName(name);
    }

    @PutMapping("/update-description{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateDescriptionById(@PathVariable Long id, @RequestParam String description) {
        receiptService.updateDescriptionById(id, description);
    }

    @PutMapping("/update-instructions/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateInstructionById(@PathVariable Long id,@RequestParam  String instruction) {
        receiptService.updateInstructionById(id, instruction);
    }

    @PutMapping("/update-dish-type/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateDishTypeById(@PathVariable Long id, @RequestParam String dishType) {
        receiptService.updateDishTypeById(id, dishType);
    }

    @PutMapping("/update-image/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateImagePathById(
            @PathVariable Long id, @RequestPart MultipartFile newImage) {
        receiptService.updateImagePathById(id, newImage);
    }

    @PutMapping("/update-cooking-time/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCookingTimeById(
            @PathVariable Long id, @RequestParam Integer cookingTime) {
        receiptService.updateCookingTimeById(id, cookingTime);
    }

    @PutMapping("/update-name/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateNameById(@PathVariable Long id, @RequestParam String newName) {
        receiptService.updateNameById(id, newName);
    }

    @DeleteMapping("/delete/{id}/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteByIdAndUserId(@PathVariable Long id, @PathVariable Long userId) {
        return receiptService.deleteByIdAndUserId(id, userId);
    }
}
