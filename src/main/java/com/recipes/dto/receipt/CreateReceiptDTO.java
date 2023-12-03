package com.recipes.dto.receipt;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateReceiptDTO {

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String description;

    @NotBlank
    @NotNull
    private String instruction;

    @Min(1)
    private Integer cookingTime;

    @Min(1)
    @Max(5)
    private Double rating;

    @NotBlank
    @NotNull
    private String dishType;

    @Min(1)
    private Long categoryId;

    @Min(1)
    private Long userId;

    @Min(1)
    private Long countryId;
}
