package com.recipes.service.nullсhecker;

import com.recipes.exceptions.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NullCheckerImpl<T> implements NullChecker<T> {

    @Value("${nullValidate.list}")
    private String messageForList;

    @Value("${nullValidate.entity}")
    private String messageForEntity;

    /**
     * Checks if the input list is not null.
     *
     * @param t The list to be checked for null.
     * @return The input list if it is not null.
     * @throws ValidationException If the input list is null, a ValidationException is thrown.
     */
    @Override
    public List<T> list(List<T> t) {
        if (t == null) {
            throw new ValidationException(messageForList);
        } else {
            return t;
        }
    }

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
