package com.recipes.service.implementation;

import com.recipes.converter.AuthenticationDTOConverter;
import com.recipes.dto.authentication.AuthenticationDTO;
import com.recipes.dto.authentication.CreateAuthenticationDTO;
import com.recipes.entity.Authentication;
import com.recipes.repository.AuthenticationRepository;
import com.recipes.service.interfaces.AuthenticationService;
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

    public AuthenticationDTO createAuthentication(CreateAuthenticationDTO createAuthenticationDTO) {
        Authentication auth = authenticationDTOConverter.toEntity(createAuthenticationDTO);
        auth = repository.save(auth);
        AuthenticationDTO dto = authenticationDTOConverter.toDto(auth);
        log.info(dto.toString() + " created");
        return dto;
    }
}
