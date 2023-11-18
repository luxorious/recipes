package com.recipes.annotation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IntegerParsingValidator implements ConstraintValidator<IntegerValidator, Integer> {

    @Override
    public void initialize(IntegerValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        } else return s > 0;
    }
}
