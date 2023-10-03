package com.recipes.annotation;

import com.recipes.annotation.validator.NullParsingValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NullParsingValidator.class)
public @interface NullValidator {

    String message() default "the value can not be 'null'!";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
