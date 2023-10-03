package com.recipes.annotation.validator;

import com.recipes.annotation.NullValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NullParsingValidator implements ConstraintValidator<NullValidator, String> {
    @Override
    public void initialize(NullValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null;
    }
}
