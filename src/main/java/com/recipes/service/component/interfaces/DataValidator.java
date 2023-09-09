package com.recipes.service.component.interfaces;

import com.recipes.entity.enumerations.Categories;
import com.recipes.entity.enumerations.DishType;
import com.recipes.exceptions.ValidationException;

public interface DataValidator {
    /**
     * Validates and converts a string value to a Long.
     *
     * @param value The string value to be validated and converted.
     * @return The converted Long value.
     * @throws ValidationException If the value is not a valid Long.
     */
    Long checkLong(String value);

    /**
     * Validates and converts a string value to a Double.
     *
     * @param value The string value to be validated and converted.
     * @return The converted Double value.
     * @throws ValidationException If the value is not a valid Double.
     */
    Double checkDouble(String value);

    /**
     * Validates and converts a string value to a Categories enumeration.
     *
     * @param value The string value to be validated and converted.
     * @return The converted Categories enumeration value.
     * @throws ValidationException If the value is not a valid Categories enumeration.
     */
    Categories checkCategories(String value);

    /**
     * Validates and converts a string value to a Countries enumeration.
     *
     * @param value The string value to be validated and converted.
     * @return The converted Countries enumeration value.
     * @throws ValidationException If the value is not a valid Countries enumeration.
     */
    Country checkCountries(String value);

    /**
     * Validates and converts a string value to a DishType enumeration.
     *
     * @param value The string value to be validated and converted.
     * @return The converted DishType enumeration value.
     * @throws ValidationException If the value is not a valid DishType enumeration.
     */
    DishType checkDishType(String value);

}
