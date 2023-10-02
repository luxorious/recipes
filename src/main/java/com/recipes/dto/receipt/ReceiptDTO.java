package com.recipes.dto.receipt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptDTO {
    private String name;
    private String description;
    private String instruction;
    private Integer cookingTime;
    private Double rating;
    private String dishType;
    private String imageLink;
    private String categoryName;
    private String firstName;
    private String lastName;
    private String value;
    private String country;
}