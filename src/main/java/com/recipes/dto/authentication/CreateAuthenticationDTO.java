package com.recipes.dto.authentication;

import com.recipes.validation.anotations.PasswordValidator;
import com.recipes.validation.anotations.RollValidator;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuthenticationDTO {

    @RollValidator
    private String role;

    @NotNull
    @NotBlank
    private String login;

    @PasswordValidator
    private String password;

    @Min(1)
    private Long userId;
}
