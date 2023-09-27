package com.recipes.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateReceiptDTO {
    private String userId;
    private String name;
    private List<@CategoriesValidator String> categories;
    private String description;
    private String instruction;
    private String ingredients;
    private String cookingTime;
    @DoubleValidator
    private String rating;
    @CountriesValidator
    private String country;
    @DishTypeValidator
    private String dishType;
    private String imageLink;
}






