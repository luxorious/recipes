package com.recipes.converter;

import com.recipes.dto.authentication.AuthenticationDTO;
import com.recipes.entity.Authentication;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticationDTOConverter {
    private final ModelMapper mapper;


    ////////////замінити щоб підтягувалося юзер айді!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public AuthenticationDTO authToDTO(Authentication auth){
        return mapper.typeMap(Authentication.class, AuthenticationDTO.class)
                ////////////замінити щоб підтягувалося юзер айді!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                .addMapping(Authentication::getId, AuthenticationDTO::setUserId)
                .map(auth);
    }

    public Authentication authToObject(AuthenticationDTO dto){
        return mapper.map(dto, Authentication.class);
    }
}
