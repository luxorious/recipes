package com.recipes.annotation;

import com.recipes.annotation.validator.CountriesParsingValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CountriesParsingValidator.class)
public @interface CountriesValidator {

    String message() default "Country not valid";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
