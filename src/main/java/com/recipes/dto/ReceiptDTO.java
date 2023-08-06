package com.recipes.dto;

import com.recipes.annotation.CategoriesValidator;
import com.recipes.annotation.CountriesValidator;
import com.recipes.annotation.DishTypeValidator;
import com.recipes.annotation.DoubleValidator;
import com.recipes.annotation.LongValidator;
import lombok.Data;

import java.util.List;

@Data
public class ReceiptDTO {

    private String id;
    private String name;
    private String description;
    private String instruction;
    private String ingredients;
    @LongValidator
    private String cookingTime;
    @DoubleValidator
    private String rating;
    @CountriesValidator
    private String country;
    @DishTypeValidator
    private String dishType;
    private List<@CategoriesValidator String> categories;
    private String imageLink;

    private String authorName;
}