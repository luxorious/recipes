package com.recipes.service.component.interfaces;

import com.recipes.exceptions.ValidationException;

import java.util.List;

public interface Converter<T> {
    /**
     * Converts a list of {@link Enum} enumeration values to a list of strings.
     *
     * @param t The list of {@link Enum} enumeration values to be converted.
     * @return The list of strings representing the converted categories.
     */
    List<String> convertEnumToStringList(List<T> t);

    /**
     * Converts a list of strings to a list of {@link Enum} enumeration values.
     *
     * @param list The list of strings to be converted.
     * @return The list of {@link Enum} enumeration values representing the converted categories.
     * @throws ValidationException If a string value cannot be converted to a valid {@link Enum} enumeration.
     */
    List<T> convertStringListToEnumList(List<String> list);

}
