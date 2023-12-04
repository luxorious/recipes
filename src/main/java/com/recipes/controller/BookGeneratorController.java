package com.recipes.controller;

import com.recipes.entity.Recipe;
import com.recipes.service.crud.interfaces.RecipeService;
import com.recipes.service.pdfgeneration.RecipePdfGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public String generateBookFromSelectedRecipes(@RequestParam List<Long> listId) throws IOException {
        List<Recipe> recipes = recipeService.findAllRecipeEntitiesByListId(listId);
        return generator.generateRecipesBook(recipes);
    }
}
