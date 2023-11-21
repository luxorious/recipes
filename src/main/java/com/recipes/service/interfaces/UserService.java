package com.recipes.service.interfaces;

import com.recipes.dto.user.CreateUserDTO;
import com.recipes.dto.user.PrivateInfoUserDTO;
import com.recipes.dto.user.UserInfoDTO;
import com.recipes.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUserEntity();
    List<UserInfoDTO> findAllUsers();

    UserInfoDTO createUser(CreateUserDTO userDTO);

    PrivateInfoUserDTO getPrivateUserInfo(Long id);

    List<UserInfoDTO> findByName(String name);

    void updateUserByIdAndFirstName(Long id, String firstName);

    void updateUserByIdAndLastName(Long id, String lastName);

    void updateUserByIdAndEMail(Long id, String eMail);

    void updateUserByIdAndAboutMe(Long id, String aboutMe);

    void updateUserByIdAndSkills(Long id, String skills);//можна зробити списком

    void updateUserByIdAndLink(Long id, String link);//можна зробити списком

    boolean deleteByIdAndPassword(Long id, String password);
}
