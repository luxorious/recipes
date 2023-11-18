package com.recipes.converter;

import com.recipes.dto.authentication.CreateAuthenticationDTO;
import com.recipes.entity.Authentication;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateAuthenticationDTOConverter {
    private final ModelMapper mapper;

    public CreateAuthenticationDTO authToDTO(Authentication auth){
        return mapper.map(auth, CreateAuthenticationDTO.class);
    }

    public Authentication authToObject(CreateAuthenticationDTO dto){
        return mapper.map(dto, Authentication.class);
    }
}
