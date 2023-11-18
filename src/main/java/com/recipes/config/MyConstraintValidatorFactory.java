package com.recipes.config;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorFactory;

public class MyConstraintValidatorFactory implements ConstraintValidatorFactory {

    @Override
    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
        if (key == MyCustomConstraintValidator.class) {
            return (T) new MyCustomConstraintValidator();
        }
        return null;
    }

    @Override
    public void releaseInstance(ConstraintValidator<?, ?> instance) {
        // Звільнення ресурсів, якщо це необхідно
    }
}
