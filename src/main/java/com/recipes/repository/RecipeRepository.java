package com.recipes.repository;

import com.recipes.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT recipe FROM Recipe recipe " +
            "WHERE recipe.name = :recipeName")
    List<Recipe> findByRecipeName(String recipeName);

    @Query("SELECT recipe FROM Recipe recipe " +
            "WHERE recipe.country.name = :country")
    List<Recipe> findAllByCountry(String country);

    @Query("SELECT recipe FROM Recipe recipe " +
            "WHERE recipe.category.categoryName = :categoryName")
    List<Recipe> findAllByCategory(String categoryName);

    @Query("SELECT recipe FROM Recipe recipe " +
            "WHERE recipe.user.firstName =: name " +
            "OR recipe.user.lastName = :name")
    List<Recipe> findAllByFullName(String name);

    @Modifying
    @Query("UPDATE Recipe recipe " +
            "SET recipe.description = :description " +
            "WHERE recipe.id = :id")
    void updateDescriptionById(Long id, String description);

    @Modifying
    @Query("UPDATE Recipe recipe " +
            "SET recipe.instruction = :instruction " +
            "WHERE recipe.id = :id")
    void updateInstructionById(Long id, String instruction);

    @Modifying
    @Query("UPDATE Recipe recipe " +
            "SET recipe.dishType = :dishType " +
            "WHERE recipe.id = :id")
    void updateDishTypeById(Long id, String dishType);

    @Modifying
    @Query("UPDATE Recipe recipe " +
            "SET recipe.imageName = :imagePath " +
            "WHERE recipe.id = :id")
    void updateImagePathById(Long id, String imagePath);

    @Modifying
    @Query("UPDATE Recipe recipe " +
            "SET recipe.cookingTime = :cookingTime " +
            "WHERE recipe.id = :id")
    void updateCookingTimeById(Long id, Integer cookingTime);

    @Modifying
    @Query("UPDATE Recipe recipe " +
            "SET recipe.name = :newName " +
            "WHERE recipe.id = :id")
    void updateNameById(Long id, String newName);

    @Modifying
    @Query("DELETE FROM Recipe recipe " +
            "WHERE recipe.id = :id " +
            "AND recipe.user.id = :userId")
    boolean deleteByIdAndUserId(Long id, Long userId);
}
