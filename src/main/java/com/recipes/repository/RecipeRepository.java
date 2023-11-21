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
            "WHERE recipe.name = :name")
    void updateDescriptionByName(String name, String description);

    @Modifying
    @Query("UPDATE Recipe recipe " +
            "SET recipe.instruction = :instruction " +
            "WHERE recipe.name = :name")
    void updateInstructionByName(String name, String instruction);

    @Modifying
    @Query("UPDATE Recipe recipe " +
            "SET recipe.dishType = :dishType " +
            "WHERE recipe.name = :name")
    void updateDishTypeByName(String name, String dishType);

    @Modifying
    @Query("UPDATE Recipe recipe " +
            "SET recipe.imagePath = :imagePath " +
            "WHERE recipe.name = :name")
    void updateImagePathByName(String name, String imagePath);

    @Modifying
    @Query("UPDATE Recipe recipe " +
            "SET recipe.cookingTime = :cookingTime " +
            "WHERE recipe.name = :name")
    void updateCookingTimeByName(String name, Integer cookingTime);

    @Modifying
    @Query("UPDATE Recipe recipe " +
            "SET recipe.name = :newName " +
            "WHERE recipe.name = :name")
    void updateNameTimeByName(String name, String newName);

    @Modifying
    @Query("DELETE FROM Recipe recipe " +
            "WHERE recipe.name = :name " +
            "AND recipe.user.id = :userId")
    boolean deleteByNameAndUserId(String name, Long userId);

    @Modifying
    @Query("DELETE FROM Recipe recipe " +
            "WHERE recipe.id = :id " +
            "AND recipe.user.id = :userId")
    boolean deleteByIdAndUserId(Long id, Long userId);
}
