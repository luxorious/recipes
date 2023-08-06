package com.recipes.service.component.implementation;

import com.recipes.exceptions.ValidationException;

public class DValidator<T> {

    public T validate(String value, Class<T> type){
        if (value == null){
            throw new ValidationException("value can not be null");
        }
        try {
            if (type == Long.class) {
                return type.cast(Long.parseLong(value));
            } else if (type == Double.class) {
                return type.cast(Double.parseDouble(value));
            } else if (type.isEnum()) {
                return type.cast(Enum.valueOf((Class<? extends Enum>) type, value));
            } else {
                throw new IllegalArgumentException("Unsupported type: " + type.getName());
            }
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid " + value);
        } catch (IllegalArgumentException e) {
            throw new ValidationException("Invalid " + value);
        }
    }

}
