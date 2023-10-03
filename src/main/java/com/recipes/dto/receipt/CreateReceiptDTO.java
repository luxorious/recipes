package com.recipes.dto.receipt;

import com.recipes.annotation.DoubleValidator;
import com.recipes.annotation.IntegerValidator;
import com.recipes.annotation.NullValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateReceiptDTO {
    private Long id;
    @NullValidator
    private String name;
    @NullValidator
    private String description;
    @NullValidator
    private String instruction;
    @IntegerValidator
    private Integer cookingTime;
    @DoubleValidator
    private Double rating;
    @NullValidator
    private String dishType;
    @NullValidator
    private String imageLink;
    @NullValidator
    private Long categoryId;
    @NullValidator
    private Long userId;
    @NullValidator
    private Long quantityId;
    @NullValidator
    private Long countryId;
}
