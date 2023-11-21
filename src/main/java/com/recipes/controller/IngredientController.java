package com.recipes.controller;

import com.recipes.dto.ingredient.IngredientDTO;
import com.recipes.service.interfaces.IngredientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    @PostMapping("/create")
    IngredientDTO create(@Valid @RequestBody IngredientDTO dto){
        return ingredientService.create(dto);
    }

    @GetMapping("/find-all")
    List<IngredientDTO> findAllIngredients(){
        return ingredientService.findAllIngredients();
    }

    @DeleteMapping("/delete/{id}")
    boolean deleteIngredientById(@PathVariable Long id){
        return ingredientService.deleteIngredientById(id);
    }
}
