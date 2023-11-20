package com.recipes.service.implementation;

import com.recipes.converter.UserDTOConverter;
import com.recipes.dto.user.CreateUserDTO;
import com.recipes.dto.user.PrivateInfoUserDTO;
import com.recipes.dto.user.UserInfoDTO;
import com.recipes.entity.User;
import com.recipes.repository.UserRepository;
import com.recipes.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDTOConverter userDTOConverter;

    @Override
    public List<User> getAllUsers() {
//        UserListDTO userListDTO =
//        return userRepository.findAll();
    return null;
    }

    @Override
    public UserInfoDTO createUser(CreateUserDTO userDTO) {
        User user = userDTOConverter.toEntity(userDTO);
        user = userRepository.save(user);
        UserInfoDTO dto = userDTOConverter.toDtoUserInfo(user);
        log.info(dto.toString() + " created");
        return dto;
    }

    @Override
    //check null - optional!!!!
    public PrivateInfoUserDTO getPrivateUserInfo(Long id){
        Optional<User> user = userRepository.findById(id);
        User us = user.get();
        return userDTOConverter.toDtoPrivateUserInfo(us);
    }
}