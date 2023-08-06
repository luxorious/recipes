package com.recipes.DTO;

import com.recipes.annotation.*;
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