package com.recipes.validation;

import com.recipes.validation.anotations.RollValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;

public class RollParsingValidator implements ConstraintValidator<RollValidator, String> {
    private Set<String> allowedRoles = new HashSet<>();

    @Override
    public void initialize(RollValidator constraint) {
        allowedRoles = Arrays.stream(constraint.roles())
                .collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
        System.out.println(allowedRoles);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.equals("")) {
            return false;
        }
        return allowedRoles.stream()
                .anyMatch(value::startsWith);
    }
}
