package com.recipes.annotation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DoubleParsingValidator implements ConstraintValidator<DoubleValidator, Double> {
    @Override
    public void initialize(DoubleValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Double s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        } else return s > 0;
    }
}
