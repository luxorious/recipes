package com.recipes.annotation.validator;

import com.recipes.annotation.DoubleValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordParsingValidator implements ConstraintValidator<DoubleValidator, String> {
    @Override
    public void initialize(DoubleValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
//        regex - minimum 8 characters, at least one letter and one number
        String phoneRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(value);

        return matcher.find();
    }
}
