package com.recipes.repository;

import com.recipes.entity.MeasureUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasureUnitRepository extends JpaRepository<MeasureUnit, Long> {
    @Query("SELECT measureUnit FROM MeasureUnit measureUnit")
    List<MeasureUnit> findAllMeasureUnits();

    @Modifying
    @Query("DELETE FROM MeasureUnit measureUnit " +
            "WHERE measureUnit.id=:id")
    boolean deleteMeasureUnitById(Long id);
}
