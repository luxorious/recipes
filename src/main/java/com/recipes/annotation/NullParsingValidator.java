package com.recipes.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class NullParsingValidator implements ConstraintValidator<NullValidator, String> {
    @Override
    public void initialize(NullValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        log.info("is valid");
        return s != null;
    }
}
