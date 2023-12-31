package com.recipes.validation.anotations;

import com.recipes.validation.PhoneParsingValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneParsingValidator.class)
public @interface PhoneValidator {
    String message() default "incorrect phone number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}