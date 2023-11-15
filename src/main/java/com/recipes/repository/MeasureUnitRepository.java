package com.recipes.repository;

import com.recipes.entity.MeasureUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureUnitRepository extends JpaRepository<MeasureUnit, Long> {
}
