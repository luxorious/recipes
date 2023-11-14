package com.recipes.service.pdfgeneration;

import com.recipes.entity.Recipe;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.util.List;

public interface RecipePdfGenerator {
    /**
     * Generates a PDF document containing a book of recipes from the provided list of Recipe objects.
     *
     * @param recipes A list of Recipe objects to include in the book.
     * @return The PDDocument representing the generated recipes book.
     * @throws IOException If an I/O exception occurs while generating the document.
     */
    PDDocument generateRecipesBook(List<Recipe> recipes) throws IOException;

    /**
     * Generates a PDF document based on the provided recipe.
     * Adds recipe details, images, page numbers, and footer.
     *
     * @param recipe The recipe object containing details to be added to the PDF.
     * @return The generated PDF document.
     * @throws IOException If an I/O error occurs during PDF creation.
     */
    PDDocument generateRecipe(Recipe recipe) throws IOException;
}
