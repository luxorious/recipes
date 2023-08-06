package com.recipes.service.component.implementation;

import com.recipes.entity.enumerations.Categories;
import com.recipes.exceptions.ValidationException;
import com.recipes.service.component.interfaces.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link Converter} interface for converting
 * between {@link Categories} enumeration and a list of strings.
 */
@Component
@RequiredArgsConstructor
public class CategoriesConverterImpl implements Converter<Categories> {

    /**
     * Converts a list of {@link Categories} enumeration values to a list of strings.
     *
     * @param categories The list of {@link Categories} enumeration values to be converted.
     * @return The list of strings representing the converted categories.
     */
    @Override
    public List<String> convertEnumToStringList(List<Categories> categories) {
        List<String> list = new ArrayList<>();
        for (Categories category : categories) {
            list.add(category.toString());
        }
        return list;
    }

    /**
     * Converts a list of strings to a list of {@link Categories} enumeration values.
     *
     * @param categories The list of strings to be converted.
     * @return The list of {@link Categories} enumeration values representing the converted categories.
     * @throws ValidationException If a string value cannot be converted to a valid {@link Categories} enumeration.
     */
    @Override
    public List<Categories> convertStringListToEnumList(List<String> categories) {
        List<Categories> list = new ArrayList<>();
        for (String category : categories) {
            list.add(Categories.valueOf(category));
        }
        return list;
    }
}
