package com.recipes.dto.authentication;

import com.recipes.validation.anotations.PasswordValidator;
import com.recipes.validation.anotations.RollValidator;
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
    @NotBlank(message = "login can not be empty")
    private String login;

    @PasswordValidator
    private String password;

    private Long userId;
//    private User user;
}
