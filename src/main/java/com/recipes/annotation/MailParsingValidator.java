package com.recipes.annotation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailParsingValidator implements ConstraintValidator<MailValidator, String> {

    /**
     * This method is called before any constraint validation is performed,
     * allowing the validator to initialize its internal state and configure
     * itself based on the provided constraint annotation.
     *
     * @param constraintAnnotation The constraint annotation instance for this validation.
     *                             It provides access to the attributes defined in the annotation.
     * @throws IllegalArgumentException If the constraint annotation is not of the expected type
     *                                  or if the initialization fails for any reason.
     */
    @Override
    public void initialize(MailValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String eMaliRegex = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$";
        Pattern pattern = Pattern.compile(eMaliRegex);
        Matcher matcher = pattern.matcher(value);

        return matcher.find();
    }
}
