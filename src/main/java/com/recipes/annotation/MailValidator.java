package com.recipes.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MailParsingValidator.class)
public @interface MailValidator {
    String message() default "incorrect e-mail";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}