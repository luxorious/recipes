package com.recipes.repository;

import com.recipes.entity.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishCategoryRepository extends JpaRepository<DishCategory, Long> {

    @Query("SELECT category FROM DishCategory category")
    List<DishCategory> findAllCategories();

    @Modifying
    @Query("DELETE FROM DishCategory category " +
            "WHERE category.id=:id")
    boolean deleteCategoryById(Long id);

}
