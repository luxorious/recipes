package com.recipes.controller;

import com.recipes.entity.Recipe;
import com.recipes.service.interfaces.RecipeService;
import com.recipes.service.pdfgeneration.RecipePdfGenerator;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/generate-book")
public class BookGeneratorController {

    private final RecipePdfGenerator generator;
    private final RecipeService recipeService;

    @GetMapping("/all")
    public PDDocument generateAllRecipes() throws IOException {
        List<Recipe> recipes = recipeService.findAllRecipeEntities();
        return generator.generateRecipesBook(recipes);
    }
}
