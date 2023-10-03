package com.recipes.dto.authentication;

import com.recipes.annotation.NullValidator;
import com.recipes.annotation.PasswordValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuthenticationDTO {
    private Long uerId;
    @NullValidator
    private String role;
    @NullValidator
    private String login;
    @PasswordValidator
    private String password;
}
