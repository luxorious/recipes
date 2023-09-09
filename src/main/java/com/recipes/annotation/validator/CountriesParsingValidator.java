package com.example.expertprojectbackend.annotation.validator;

import com.example.expertprojectbackend.annotation.CountriesValidator;

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
            Country.valueOf(s);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
