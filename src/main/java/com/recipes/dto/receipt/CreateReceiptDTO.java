package com.recipes.dto.receipt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateReceiptDTO {
    private String name;
    private String description;
    private String instruction;
    private Integer cookingTime;
    private Double rating;
    private String dishType;
    private String imageLink;
    private Long categoryId;
    private Long userId;
    private Long countryId;
}
