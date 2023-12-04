package com.recipes.converter.interfaces;

import com.recipes.dto.user.CreateUserDTO;
import com.recipes.dto.user.PrivateInfoUserDTO;
import com.recipes.dto.user.UserInfoDTO;
import com.recipes.entity.User;

import java.util.List;

public interface UserDTOConverter {

    UserInfoDTO toDtoUserInfo(User user);

    User toEntity(CreateUserDTO userDTO);

    PrivateInfoUserDTO toDtoPrivateUserInfo(User user);

    List<UserInfoDTO> toListDto(List<User> users);
}
