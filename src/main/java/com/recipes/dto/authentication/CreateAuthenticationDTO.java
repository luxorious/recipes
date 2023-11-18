package com.recipes.dto.authentication;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuthenticationDTO {
    @NotNull
    @NotBlank(message = "role is mandatory")
//    @MyCustomValidation(value = {"error", "mistake"})
    private String role;
//    @NotNull
//    @NotBlank(message = "login is mandatory")
    private String login;
//    @NotNull
//    @NotBlank(message = "password is mandatory")
    private String password;

}
