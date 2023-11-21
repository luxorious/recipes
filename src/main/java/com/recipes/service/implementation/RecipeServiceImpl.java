package com.recipes.service.implementation;

import com.recipes.converter.RecipeDTOConverter;
import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.RecipeDTO;
import com.recipes.entity.Recipe;
import com.recipes.repository.RecipeRepository;
import com.recipes.service.interfaces.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;
    private final RecipeDTOConverter converter;

    @Override
    @Transactional
    public List<RecipeDTO> findAll() {
        return converter.toListDto(findAllRecipeEntities());
    }

    @Override
    @Transactional
    public RecipeDTO save(CreateReceiptDTO receiptDTO) {
        Recipe recipe = repository.save(converter.toEntity(receiptDTO));
        return converter.toDto(recipe);
    }

    @Override
    @Transactional
    public List<Recipe> findAllRecipeEntities() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public List<RecipeDTO> findAllByCountry(String country) {
        List<Recipe> recipes = repository.findAllByCountry(country);
        return converter.toListDto(recipes);
    }

    @Transactional
    @Override
    public List<RecipeDTO> findAllByCategory(String categoryName) {
        List<Recipe> recipes = repository.findAllByCategory(categoryName);
        return converter.toListDto(recipes);
    }

    @Transactional
    @Override
    public List<RecipeDTO> findAllByFullName(String fullName) {
        List<Recipe> recipes = repository.findAllByFullName(fullName);
        return converter.toListDto(recipes);
    }

    @Transactional
    @Override
    public List<RecipeDTO> findByName(String name) {
        List<Recipe> recipe = repository.findAllByFullName(name);
        return converter.toListDto(recipe);
    }

    @Transactional
    @Override
    public void updateDescriptionByName(String name, String description) {
        repository.updateDescriptionByName(name, description);
    }

    @Transactional
    @Override
    public void updateInstructionByName(String name, String instruction) {
        repository.updateInstructionByName(name, instruction);
    }

    @Transactional
    @Override
    public void updateDishTypeByName(String name, String dishType) {
        repository.updateDishTypeByName(name, dishType);
    }

    @Transactional
    @Override
    public void updateImagePathByName(String name, String imagePath) {
        repository.updateImagePathByName(name, imagePath);
    }

    @Transactional
    @Override
    public void updateCookingTimeByName(String name, Integer cookingTime) {
        repository.updateCookingTimeByName(name, cookingTime);
    }

    @Transactional
    @Override
    public void updateNameByName(String name, String newName) {
        repository.updateNameTimeByName(name, newName);
    }

    @Transactional
    @Override
    public boolean deleteByNameAndUserId(String name, Long userId) {
        return repository.deleteByNameAndUserId(name, userId);
    }

    @Transactional
    @Override
    public boolean deleteByIdAndUserId(Long id, Long userId) {
        return repository.deleteByIdAndUserId(id, userId);
    }
}
