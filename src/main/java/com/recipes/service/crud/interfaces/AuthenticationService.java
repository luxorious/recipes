package com.recipes.service.crud.interfaces;

import com.recipes.dto.authentication.AuthenticationDTO;
import com.recipes.dto.authentication.CreateAuthenticationDTO;
import com.recipes.dto.authentication.RestorePasswordDTO;

public interface AuthenticationService {

    AuthenticationDTO createAuthentication(CreateAuthenticationDTO createAuthenticationDTO);

    AuthenticationDTO getAuthenticationByUserId(Long id);

    AuthenticationDTO getAuthenticationById(Long id);

    AuthenticationDTO updateAuthenticationPasswordByLogin(RestorePasswordDTO passwordDTO);

    boolean deleteAuthenticationByLoginAndPassword(String login, String password);

}
