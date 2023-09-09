package com.example.expertprojectbackend.annotation.validator;

import com.example.expertprojectbackend.annotation.CategoriesValidator;
import com.recipes.entity.enumerations.Categories;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoriesParsingValidator implements ConstraintValidator<CategoriesValidator, String> {
    @Override
    public void initialize(CategoriesValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s==null){
            return false;
        }
        try{
            Categories.valueOf(s);
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }
}
