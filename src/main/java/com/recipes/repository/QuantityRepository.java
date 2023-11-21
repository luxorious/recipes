package com.recipes.repository;

import com.recipes.entity.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity, Long> {
    @Query("SELECT quantity FROM Quantity quantity")
    List<Quantity> findAllQuantities();

    @Modifying
    @Query("DELETE FROM Quantity quantity " +
            "WHERE quantity.id=:id")
    boolean deleteQuantityById(Long id);
}
