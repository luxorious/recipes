package com.recipes.converter;

import com.recipes.dto.authentication.AuthenticationDTO;
import com.recipes.dto.authentication.CreateAuthenticationDTO;
import com.recipes.entity.Authentication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class AuthenticationDTOConverter {
    private final ModelMapper mapper;

    public Authentication toEntity(CreateAuthenticationDTO dto) {
        return mapper.typeMap(CreateAuthenticationDTO.class, Authentication.class)
                .addMapping(CreateAuthenticationDTO::getUserId,
                        (auth, id)->auth.getUser().setId((Long) id))
                .map(dto);
    }

    public AuthenticationDTO toDto(Authentication auth){
        return mapper.typeMap(Authentication.class, AuthenticationDTO.class)
                .addMapping(authentication->authentication.getUser().getId(),
                        AuthenticationDTO::setUserId)
                .map(auth);
    }
}
