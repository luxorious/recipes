package com.recipes.repository;

import com.recipes.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findByName(String country);

    @Modifying
    @Query("DELETE FROM Country country " +
            "WHERE country.id = :id")
    boolean deleteCountryById(Long id);
}
