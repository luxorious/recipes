package com.recipes.service.crud.interfaces;

import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.RecipeDTO;
import com.recipes.entity.Recipe;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RecipeService {

    Recipe findById(Long id);

    List<RecipeDTO> findAll();

    RecipeDTO save(CreateReceiptDTO receiptDTO, MultipartFile file);

    List<Recipe> findAllRecipeEntities();

    List<Recipe> findAllRecipeEntitiesByListId(List<Long> listId);

    List<RecipeDTO> findAllByCountry(String country);

    List<RecipeDTO> findAllByCategory(String categoryName);

    List<RecipeDTO> findAllByAuthorsFullName(String fullName);

    List<RecipeDTO> findByRecipeName(String name);

    void updateDescriptionById(Long id, String description);

    void updateInstructionById(Long id, String instruction);

    void updateDishTypeById(Long id, String dishType);

    void updateImagePathById(Long id, MultipartFile image);

    void updateCookingTimeById(Long id, Integer cookingTime);

    void updateNameById(Long id, String newName);

    boolean deleteByIdAndUserId(Long id, Long userId);
}
