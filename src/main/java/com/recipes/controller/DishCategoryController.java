package com.recipes.controller;

import com.recipes.dto.category.DishCategoryDTO;
import com.recipes.service.interfaces.DishCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/dish-category")
public class DishCategoryController {
    private final DishCategoryService dishCategoryService;

    @PostMapping("/create")
    DishCategoryDTO create(@Valid @RequestBody DishCategoryDTO dto){
        return dishCategoryService.create(dto);
    }

    @GetMapping("/find-all")
    List<DishCategoryDTO> findAllCategories(){
        return dishCategoryService.findAllCategories();
    }

    @DeleteMapping("/delete/{id}")
    boolean deleteCategoryById(@PathVariable Long id){
        return dishCategoryService.deleteCategoryById(id);
    }
}
