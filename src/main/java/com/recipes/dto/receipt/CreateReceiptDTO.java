package com.recipes.dto.receipt;

import com.recipes.annotation.DoubleValidator;
import com.recipes.annotation.IntegerValidator;
import com.recipes.annotation.LongValidator;
import com.recipes.annotation.NullValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateReceiptDTO {
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
    @LongValidator
    private Long categoryId;
    @LongValidator
    private Long userId;
    @LongValidator
    private Long quantityId;
    @LongValidator
    private Long countryId;
}
