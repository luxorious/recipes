package com.recipes.controller;

import com.recipes.dto.receipt.RecipeDTO;
import com.recipes.entity.Recipe;
import com.recipes.service.crud.interfaces.RecipeService;
import com.recipes.service.pdfgeneration.RecipePdfGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/generate")
public class BookGeneratorController {

    private final RecipePdfGenerator generator;
    private final RecipeService recipeService;

    //return path with generatedBook
    @GetMapping("/bock")
    public String generateAllRecipes() throws IOException {
        List<Recipe> recipes = recipeService.findAllRecipeEntities();
        return generator.generateRecipesBook(recipes);
    }

    @GetMapping("/page/{id}")
    public String generateRecipe(@PathVariable Long id) throws IOException {
        Recipe recipe = recipeService.findById(id);
        return generator.generateRecipe(recipe);


    }

    @GetMapping("/book/user-list")
    public String generateBookFromSelectedRecipes(List<RecipeDTO> dtos) throws IOException {
        //або ж можна просто id передати й усім простіше буде
        List<Recipe> recipes = new ArrayList<>();
        for (RecipeDTO dto : dtos){
            Recipe recipe = recipeService.findById(dto.getId());
            recipes.add(recipe);
        }//зробити цю операцію в іншому потоці, але почитати про взаємодію багатопотоковості з БД
        return generator.generateRecipesBook(recipes);
    }
}
