package com.example.expertprojectbackend.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = com.recipes.annotation.validator.LongValidator.class)
public @interface LongValidator {
    String message() default "the value must be long number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}