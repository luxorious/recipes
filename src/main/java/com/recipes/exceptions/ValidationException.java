package com.recipes.exceptions;

/**
 * Custom exception class that represents a validation error.
 * This exception can be thrown when data fails validation checks.
 */
public class ValidationException extends RuntimeException {
    /**
     * Constructs a new ValidationException with the specified detail message.
     *
     * @param message The detail message, which should provide information about the validation error.
     */
    public ValidationException(String message) {
        super(message);
    }
}
