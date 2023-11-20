package com.recipes.service.interfaces;

import com.recipes.dto.user.CreateUserDTO;
import com.recipes.dto.user.PrivateInfoUserDTO;
import com.recipes.dto.user.UserInfoDTO;
import com.recipes.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    UserInfoDTO createUser(CreateUserDTO userDTO);
    PrivateInfoUserDTO getPrivateUserInfo(Long id);
}
