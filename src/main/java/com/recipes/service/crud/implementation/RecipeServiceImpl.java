package com.recipes.service.crud.implementation;

import com.recipes.converter.interfaces.RecipeDTOConverter;
import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.RecipeDTO;
import com.recipes.entity.Recipe;
import com.recipes.repository.RecipeRepository;
import com.recipes.service.crud.interfaces.RecipeService;
import com.recipes.service.nullchecker.NullChecker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;
    private final RecipeDTOConverter converter;
    private final NullChecker<Recipe> checker;


    @Value("${savingFiles.pathSavingImages}")
    private String pathSavingImages;

    @Override
    public Recipe findById(Long id) {
        return checker.entity(repository.findById(id));
    }

    @Override
    @Transactional
    public List<RecipeDTO> findAll() {
        return converter.toListDto(findAllRecipeEntities());
    }

    @Override
    @Transactional
    public RecipeDTO save(CreateReceiptDTO receiptDTO, MultipartFile file) {
        saveFile(file);
        String imageName = file.getOriginalFilename();
        Recipe recipe = repository.save(converter.toEntity(receiptDTO, imageName));
        return converter.toDto(recipe);
    }

    @Override
    @Transactional
    public List<Recipe> findAllRecipeEntities() {
        return repository.findAll();
    }

    @Override
    public List<Recipe> findAllRecipeEntitiesByListId(List<Long> listId) {
        List<Recipe> recipes = new ArrayList<>();
        for (Long id : listId) {
            recipes.add(findById(id));
        }
        return recipes;
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
    public List<RecipeDTO> findAllByAuthorsFullName(String fullName) {
        List<Recipe> recipes = repository.findAllByFullName(fullName);
        return converter.toListDto(recipes);
    }

    @Transactional
    @Override
    public List<RecipeDTO> findByRecipeName(String name) {
        List<Recipe> recipe = repository.findByRecipeName(name);
        return converter.toListDto(recipe);
    }

    @Transactional
    @Override
    public void updateDescriptionById(Long id, String description) {
        repository.updateDescriptionById(id, description);
    }

    @Transactional
    @Override
    public void updateInstructionById(Long id, String instruction) {
        repository.updateInstructionById(id, instruction);
    }

    @Transactional
    @Override
    public void updateDishTypeById(Long id, String dishType) {
        repository.updateDishTypeById(id, dishType);
    }

    @Transactional
    @Override
    public void updateImagePathById(Long id, MultipartFile image) {
        String imagePath = pathSavingImages + image.getOriginalFilename();
        saveFile(image);
        repository.updateImagePathById(id, imagePath);
    }

    @Transactional
    @Override
    public void updateCookingTimeById(Long id, Integer cookingTime) {
        repository.updateCookingTimeById(id, cookingTime);
    }

    @Transactional
    @Override
    public void updateNameById(Long id, String newName) {
        repository.updateNameById(id, newName);
    }

    @Transactional
    @Override
    public boolean deleteByIdAndUserId(Long id, Long userId) {
        Recipe recipe = findById(id);
        deleteFile(recipe.getImageName());
        return repository.deleteByIdAndUserId(id, userId);
    }

    private void saveFile(MultipartFile file) {
        try {
            Path filePath = Paths.get(pathSavingImages, file.getOriginalFilename());
            Files.createDirectories(Path.of(pathSavingImages));
            file.transferTo(filePath);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void deleteFile(String nameWithPath) {
        Path path = Paths.get(nameWithPath);

        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
