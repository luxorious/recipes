package com.recipes.service.interfaces;

import com.recipes.dto.authentication.AuthenticationDTO;
import com.recipes.dto.authentication.CreateAuthenticationDTO;

public interface AuthenticationService {
    AuthenticationDTO createAuthentication(CreateAuthenticationDTO createAuthenticationDTO);
    AuthenticationDTO getAuthenticationByUserId(Long id);
    AuthenticationDTO getAuthenticationById(Long id);
    AuthenticationDTO updateAuthenticationPasswordByLogin(String login, String newPassword);
    boolean deleteAuthenticationByLoginAndPassword(String login, String password);

}
