package com.recipes.service.nullсhecker;

import com.recipes.exceptions.ValidationException;

import java.util.List;
import java.util.Optional;

public interface NullChecker<T> {

    /**
     * Checks if the input list is not null.
     *
     * @param t The list to be checked for null.
     * @return The input list if it is not null.
     * @throws ValidationException If the input list is null, a ValidationException is thrown.
     */
    List<T> list(List<T> t);

    /**
     * Returns the value from the given Optional if present.
     *
     * @param t The Optional containing the entity to be retrieved.
     * @return The entity from the Optional, if present.
     * @throws ValidationException If the Optional is empty, a ValidationException is thrown.
     */
    T entity(Optional<T> t);

}
