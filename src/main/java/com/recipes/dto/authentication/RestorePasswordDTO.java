package com.recipes.dto.authentication;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RestorePasswordDTO {

    @NotBlank
    @NotNull
    private String login;

    @NotBlank
    @NotNull
    private String eMail;

    @NotBlank
    @NotNull
    private String newPassword;
}
