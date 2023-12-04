package com.recipes.service.nullchecker;

import com.recipes.exceptions.ValidationException;

import java.util.Optional;

public interface NullChecker<T> {

    /**
     * Returns the value from the given Optional if present.
     *
     * @param t The Optional containing the entity to be retrieved.
     * @return The entity from the Optional, if present.
     * @throws ValidationException If the Optional is empty, a ValidationException is thrown.
     */
    T entity(Optional<T> t);

}
