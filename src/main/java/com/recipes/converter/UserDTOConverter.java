package com.recipes.converter;

import com.recipes.dto.user.CreateUserDTO;
import com.recipes.dto.user.PrivateInfoUserDTO;
import com.recipes.dto.user.UserInfoDTO;
import com.recipes.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserDTOConverter {

    private final ModelMapper mapper;

    public UserInfoDTO toDtoUserInfo(User user) {
        return mapper.typeMap(User.class, UserInfoDTO.class)
                .map(user);
    }

    public User toEntity(CreateUserDTO userDTO) {
        return mapper.typeMap(CreateUserDTO.class, User.class)
                .map(userDTO);
    }

    //not tested
    public PrivateInfoUserDTO toDtoPrivateUserInfo(User user) {
        return mapper.typeMap(User.class, PrivateInfoUserDTO.class)
                .addMapping(us -> us.getAuthentication().getLogin(),
                        (infoDto, value) -> infoDto.setLogin((String) value))
                .addMapping(us -> us.getAuthentication().getRole(),
                        (infoDto, value) -> infoDto.setRole((String) value))
                .map(user);
    }

    public List<UserInfoDTO> toListDto(List<User> users) {
        return users.stream()
                .map(this::toDtoUserInfo)
                .collect(Collectors.toList());
    }
}
