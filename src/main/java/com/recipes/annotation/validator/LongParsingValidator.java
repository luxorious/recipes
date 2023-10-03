package com.recipes.annotation.validator;

import com.recipes.annotation.LongValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class LongParsingValidator implements ConstraintValidator<LongValidator, Long> {

    @Override
    public void initialize(LongValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        } else return s > 0;
    }
}
