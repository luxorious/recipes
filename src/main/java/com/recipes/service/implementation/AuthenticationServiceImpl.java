package com.recipes.service.implementation;

import com.recipes.converter.AuthenticationDTOConverter;
import com.recipes.converter.CreateAuthenticationDTOConverter;
import com.recipes.dto.authentication.AuthenticationDTO;
import com.recipes.dto.authentication.CreateAuthenticationDTO;
import com.recipes.entity.Authentication;
import com.recipes.repository.AuthenticationRepository;
import com.recipes.service.interfaces.AuthenticationService;
import jakarta.validation.Validator;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Data
@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationRepository repository;
    private final AuthenticationDTOConverter authenticationDTOConverter;
    private final CreateAuthenticationDTOConverter createAuthenticationDTOConverter;
    private final Validator validator;

    public AuthenticationDTO createAuthentication(CreateAuthenticationDTO createAuthenticationDTO) {
        log.info(createAuthenticationDTO.toString() + "DTOBLEA");
        Authentication auth = createAuthenticationDTOConverter.authToObject(createAuthenticationDTO);
        log.info(auth.toString()+"ENTITYBLJKL");

        AuthenticationDTO dto = authenticationDTOConverter.authToDTO(repository.save(auth));
        log.info(dto.toString() + " DTOOOOOOOOOOOOOOOO");
        return dto;
    }
}
