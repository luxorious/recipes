package com.recipes.annotation;

import com.recipes.annotation.validator.IntegerParsingValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IntegerParsingValidator.class)
public @interface IntegerValidator {

    String message() default "the value must be integer number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
