package com.recipes.mapper;

import com.recipes.dto.authentication.AuthenticationDTO;
import com.recipes.entity.Authentication;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@RequiredArgsConstructor
public class AuthenticationConverter {
    private final ModelMapper mapper;

    public AuthenticationDTO authToDTO(Authentication auth){
        return mapper.map(auth, AuthenticationDTO.class);
    }

    public Authentication authToObject(AuthenticationDTO dto){
        return mapper.map(dto, Authentication.class);
    }


}
