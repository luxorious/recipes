package com.recipes.annotation.validator;

import com.recipes.entity.enumerations.Categories;
import com.recipes.entity.enumerations.DishType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingValidator implements ConstraintValidator<Validator, String> {
    /**
     * Initializes the validator in preparation for
     * {@link #isValid(Object, ConstraintValidatorContext)} calls.
     * The constraint annotation for a given constraint declaration
     * is passed.
     * <p>
     * This method is guaranteed to be called before any use of this instance for
     * validation.
     * <p>
     * The default implementation is a no-op.
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(Validator constraintAnnotation) {
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
        if (value == null) {
            return false;
        } else return categoriesValidator(value) ||
                countryValidator(value) ||
                dishTypeValidator(value) ||
                doubleValidator(value) ||
                intValidator(value) ||
                longValidator(value) ||
                mailValidator(value) ||
                phoneValidator(value);
    }

    private boolean categoriesValidator(String s) {
        try {
            Categories.valueOf(s);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean countryValidator(String s) {
        try {
            Country.valueOf(s);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean dishTypeValidator(String s) {
        try {
            DishType.valueOf(s);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean doubleValidator(String s) {
        try {
            return Double.parseDouble(s) < 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean intValidator(String s) {
        try {
            return Integer.parseInt(s) < 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean longValidator(String s) {
        try {
            return Long.parseLong(s) < 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean mailValidator(String s) {
        String eMaliRegex = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$";
        Pattern pattern = Pattern.compile(eMaliRegex);
        Matcher matcher = pattern.matcher(s);

        return matcher.find();
    }

    private boolean phoneValidator(String s) {
        String phoneRegex = "^(\\+\\d{1,3})?\\d{6,14}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(s);

        return matcher.find();
    }
}
