package com.recipes.annotation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class LongValidator implements ConstraintValidator<com.recipes.annotation.LongValidator, String> {

    @Override
    public void initialize(com.recipes.annotation.LongValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }
        try {
            return Long.parseLong(s)<0;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
