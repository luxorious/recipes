package com.recipes.service.nullchecker;

import com.recipes.exceptions.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NullCheckerImpl<T> implements NullChecker<T> {

    @Value("${nullValidate.entity}")
    private String messageForEntity;

    /**
     * Returns the value from the given Optional if present.
     *
     * @param t The Optional containing the entity to be retrieved.
     * @return The entity from the Optional, if present.
     * @throws ValidationException If the Optional is empty, a ValidationException is thrown.
     */
    @Override
    public T entity(Optional<T> t) {
        return t.orElseThrow(() -> new ValidationException(messageForEntity));
    }
}
