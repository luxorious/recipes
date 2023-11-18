package com.recipes.config;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;

public class MyCustomConstraintValidator implements ConstraintValidator<MyCustomValidation, String> {
    private Set<String> allowedPrefixes;

    @Override
    public void initialize(MyCustomValidation constraint) {
        allowedPrefixes = Arrays.stream( constraint.value() )
                .collect( collectingAndThen( toSet(), Collections::unmodifiableSet ) );
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value == null )
            return true;

        return allowedPrefixes.stream()
                .anyMatch( value::startsWith );
    }
}
