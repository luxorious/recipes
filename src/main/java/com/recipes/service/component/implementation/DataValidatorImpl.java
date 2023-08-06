//package com.recipes.service.component.implementation;
//
//import com.recipes.entity.enumerations.Categories;
//import com.recipes.entity.enumerations.Countries;
//import com.recipes.entity.enumerations.DishType;
//import com.recipes.exceptions.ValidationException;
//import com.recipes.service.component.interfaces.DataValidator;
//import com.recipes.service.component.interfaces.NullValidate;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * Implementation of the {@link DataValidator} interface that provides methods
// * for validating different types of data.
// */
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class DataValidatorImpl implements DataValidator {
//
//    private final NullValidate<String> validate;
//
//    @Value("${dataValidator.longMessage}")
//    private String longMessage;
//    @Value("${dataValidator.doubleMessage}")
//    private String doubleMessage;
//    @Value("${dataValidator.countryMessage}")
//    private String countryMessage;
//    @Value("${dataValidator.dishTypeMessage}")
//    private String dishTypeMessage;
//    @Value("${dataValidator.categoryMessage}")
//    private String categoryMessage;
//
//    /**
//     * Validates and converts a string value to a Long.
//     *
//     * @param value The string value to be validated and converted.
//     * @return The converted Long value.
//     * @throws ValidationException If the value is not a valid Long.
//     */
//    @Override
//    public Long checkLong(String value) {
//        validate.nullChecker(value);
//        try {
//            return Long.parseLong(value);
//        } catch (NumberFormatException e) {
//            throw new ValidationException(longMessage);
//        }
//    }
//
//    /**
//     * Validates and converts a string value to a Double.
//     *
//     * @param value The string value to be validated and converted.
//     * @return The converted Double value.
//     * @throws ValidationException If the value is not a valid Double.
//     */
//    @Override
//    public Double checkDouble(String value) {
//        validate.nullChecker(value);
//        try {
//            return Double.parseDouble(value);
//        } catch (NumberFormatException e) {
//            throw new ValidationException(doubleMessage);
//        }
//    }
//
//    /**
//     * Validates and converts a string value to a Countries enumeration.
//     *
//     * @param value The string value to be validated and converted.
//     * @return The converted Countries enumeration value.
//     * @throws ValidationException If the value is not a valid Countries enumeration.
//     */
//    @Override
//    public Countries checkCountries(String value) {
//        validate.nullChecker(value);
//        try {
//            return Countries.valueOf(value);
//        } catch (IllegalArgumentException e) {
//            throw new ValidationException(countryMessage);
//        }
//    }
//
//    /**
//     * Validates and converts a string value to a Categories enumeration.
//     *
//     * @param value The string value to be validated and converted.
//     * @return The converted Categories enumeration value.
//     * @throws ValidationException If the value is not a valid Categories enumeration.
//     */
//    @Override
//    public Categories checkCategories(String value) {
//        validate.nullChecker(value);
//        try {
//            return Categories.valueOf(value);
//        } catch (IllegalArgumentException e) {
//            throw new ValidationException(categoryMessage);
//        }
//    }
//
//    /**
//     * Validates and converts a string value to a DishType enumeration.
//     *
//     * @param value The string value to be validated and converted.
//     * @return The converted DishType enumeration value.
//     * @throws ValidationException If the value is not a valid DishType enumeration.
//     */
//    @Override
//    public DishType checkDishType(String value) {
//        validate.nullChecker(value);
//        try {
//            return DishType.valueOf(value);
//        } catch (IllegalArgumentException e) {
//            throw new ValidationException(dishTypeMessage);
//        }
//    }
//}
