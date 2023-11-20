package com.recipes.validation.anotations;

import com.recipes.validation.RollParsingValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RollParsingValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface RollValidator {

    String message() default "Role not in list, choose another role!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] roles() default {"USER", "MODERATOR", "ADMIN"};
}

