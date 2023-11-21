package com.recipes.repository;

import com.recipes.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    @Query("SELECT ingredient FROM Ingredient ingredient")
    List<Ingredient> findAllIngredients();

    @Modifying
    @Query("DELETE FROM Ingredient ingredient " +
            "WHERE ingredient.id=:id")
    boolean deleteIngredientById(Long id);
}
