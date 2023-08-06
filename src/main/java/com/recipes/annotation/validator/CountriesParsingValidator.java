package com.recipes.annotation.validator;

import com.recipes.annotation.CountriesValidator;
import com.recipes.entity.enumerations.Countries;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CountriesParsingValidator implements ConstraintValidator<CountriesValidator, String> {
    @Override
    public void initialize(CountriesValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }

        try {
            Countries.valueOf(s);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
