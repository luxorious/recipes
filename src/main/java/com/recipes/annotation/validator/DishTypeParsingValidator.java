package com.recipes.annotation.validator;

import com.recipes.annotation.DishTypeValidator;
import com.recipes.entity.enumerations.DishType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DishTypeParsingValidator implements ConstraintValidator<DishTypeValidator, String> {
    @Override
    public void initialize(DishTypeValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }
        try {
            DishType.valueOf(s);
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }
}
