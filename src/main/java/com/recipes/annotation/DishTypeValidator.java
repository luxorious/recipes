package com.recipes.annotation;

import com.recipes.annotation.validator.DishTypeParsingValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DishTypeParsingValidator.class)
public @interface DishTypeValidator {
    String message() default "Wrong Dish Type";

    Class<?>[] group() default {};

    Class<? extends Payload>[] payload() default {};
}
