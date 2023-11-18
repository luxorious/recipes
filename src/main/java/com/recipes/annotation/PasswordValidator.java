package com.recipes.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordParsingValidator.class)
public @interface PasswordValidator {

    String message() default
            "the password must have a minimum 8 characters, at least one letter and one number";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
