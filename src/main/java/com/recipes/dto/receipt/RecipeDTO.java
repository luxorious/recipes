package com.recipes.dto.receipt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDTO {
    private Long id;
    private String name;
    private String description;
    private String instruction;
    private Integer cookingTime;
    private Double rating;
    private String dishType;
    private String imageName;
    private String categoryName;
    private String firstName;
    private String lastName;
    private String countryName;
}