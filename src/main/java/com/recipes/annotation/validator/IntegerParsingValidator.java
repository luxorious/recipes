package com.recipes.annotation.validator;

import com.recipes.annotation.IntegerValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


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
