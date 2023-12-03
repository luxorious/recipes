package com.recipes.converter.implementations;

import com.recipes.converter.interfaces.AuthenticationDTOConverter;
import com.recipes.dto.authentication.AuthenticationDTO;
import com.recipes.dto.authentication.CreateAuthenticationDTO;
import com.recipes.entity.Authentication;
import com.recipes.entity.User;
import com.recipes.service.crud.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class AuthenticationDTOConverterImpl implements AuthenticationDTOConverter {

    private final ModelMapper mapper;
    private final UserService userService;

    @Override
    public Authentication toEntity(CreateAuthenticationDTO dto) {
        Authentication authentication = mapper.map(dto, Authentication.class);

        User user = userService.findByIdEntity(dto.getUserId());
        authentication.setUser(user);
        return authentication;
    }

    @Override
    public AuthenticationDTO toDto(Authentication auth) {
        return mapper.typeMap(Authentication.class, AuthenticationDTO.class)
                .addMapping(authentication -> authentication.getUser().getId(),
                        AuthenticationDTO::setUserId)
                .map(auth);
    }
}
