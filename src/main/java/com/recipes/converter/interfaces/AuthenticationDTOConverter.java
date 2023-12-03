package com.recipes.converter.interfaces;

import com.recipes.dto.authentication.AuthenticationDTO;
import com.recipes.dto.authentication.CreateAuthenticationDTO;
import com.recipes.entity.Authentication;

public interface AuthenticationDTOConverter {
    Authentication toEntity(CreateAuthenticationDTO dto);

    AuthenticationDTO toDto(Authentication auth);
}
