package com.recipes.annotation.validator;

import com.recipes.annotation.DoubleValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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
