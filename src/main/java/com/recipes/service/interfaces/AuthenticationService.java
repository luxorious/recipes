package com.recipes.service.interfaces;

import com.recipes.dto.authentication.AuthenticationDTO;
import com.recipes.dto.authentication.CreateAuthenticationDTO;

public interface AuthenticationService {
    AuthenticationDTO createAuthentication(CreateAuthenticationDTO createAuthenticationDTO);
}
