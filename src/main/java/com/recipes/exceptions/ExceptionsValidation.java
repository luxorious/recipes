package com.recipes.exceptions;

public interface ExceptionsValidation<T> {

    T nullChecker(T t);

    T numberValidator(T t);

    T checkRequiredFields(T t);
}
