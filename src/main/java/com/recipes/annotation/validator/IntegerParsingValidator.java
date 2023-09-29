package com.recipes.annotation.validator;

import com.recipes.annotation.IntegerValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class IntegerParsingValidator implements ConstraintValidator<IntegerValidator, String> {

    @Override
    public void initialize(IntegerValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }
        try {
            return Integer.parseInt(s)<0;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
