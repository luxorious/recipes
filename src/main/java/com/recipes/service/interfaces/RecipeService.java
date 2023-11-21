package com.recipes.service.interfaces;

import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.RecipeDTO;
import com.recipes.entity.Recipe;

import java.util.List;

public interface RecipeService {

    List<RecipeDTO> findAll();

    RecipeDTO save(CreateReceiptDTO receiptDTO);

    List<Recipe> findAllRecipeEntities();

    List<RecipeDTO> findAllByCountry(String country);

    List<RecipeDTO> findAllByCategory(String categoryName);

    List<RecipeDTO> findAllByFullName(String fullName);

    List<RecipeDTO> findByName(String name);


    void updateDescriptionByName(String name, String description);


    void updateInstructionByName(String name, String instruction);


    void updateDishTypeByName(String name, String dishType);


    void updateImagePathByName(String name, String imagePath);


    void updateCookingTimeByName(String name, Integer cookingTime);


    void updateNameByName(String name, String newName);


    boolean deleteByNameAndUserId(String name, Long userId);


    boolean deleteByIdAndUserId(Long id, Long userId);
}
