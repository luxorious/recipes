package com.recipes.service.crud.implementation;

import com.recipes.converter.interfaces.UserDTOConverter;
import com.recipes.dto.user.CreateUserDTO;
import com.recipes.dto.user.PrivateInfoUserDTO;
import com.recipes.dto.user.UserInfoDTO;
import com.recipes.entity.User;
import com.recipes.repository.UserRepository;
import com.recipes.service.crud.interfaces.UserService;
import com.recipes.service.nullсhecker.NullChecker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDTOConverter converter;
    private final NullChecker<User> nullChecker;

    //метод для внутрішнього використання для запобігання конвертації в дто і назад
    @Override
    public User findByIdEntity(Long id) {
        return nullChecker.entity(userRepository.findById(id));
    }

    //метод для внутрішнього використання для запобігання конвертації в дто і назад
    @Transactional
    @Override
    public List<User> findAllUserEntity() {
        return userRepository.findAllUsers();
    }

    @Transactional
    @Override
    public List<UserInfoDTO> findAllUsers() {
        return converter.toListDto(findAllUserEntity());
    }

    @Transactional
    @Override
    public UserInfoDTO createUser(CreateUserDTO userDTO) {
        User user = converter.toEntity(userDTO);
        user = userRepository.save(user);
        UserInfoDTO dto = converter.toDtoUserInfo(user);
        log.info(dto.toString() + " created");
        return dto;
    }

    @Transactional
    @Override
    public PrivateInfoUserDTO getPrivateUserInfo(Long id) {
        User user = nullChecker.entity(userRepository.findById(id));
        return converter.toDtoPrivateUserInfo(user);
    }

    @Transactional
    @Override
    public List<UserInfoDTO> findByName(String name) {
        List<User> users = userRepository.findByName(name);
        return converter.toListDto(users);
    }

    @Transactional
    @Override
    public void updateUserByIdAndFirstName(Long id, String firstName) {
        userRepository.updateUserByIdAndFirstName(id, firstName);
    }

    @Transactional
    @Override
    public void updateUserByIdAndLastName(Long id, String lastName) {
        userRepository.updateUserByIdAndLastName(id, lastName);
    }

    @Transactional
    @Override
    public void updateUserByIdAndEMail(Long id, String eMail) {
        userRepository.updateUserByIdAndEMail(id, eMail);
    }

    @Transactional
    @Override
    public void updateUserByIdAndAboutMe(Long id, String aboutMe) {
        userRepository.updateUserByIdAndAboutMe(id, aboutMe);
    }

    @Transactional
    @Override
    public void updateUserByIdAndSkills(Long id, String skills) {
        userRepository.updateUserByIdAndSkills(id, skills);
    }

    @Transactional
    @Override
    public void updateUserByIdAndLink(Long id, String link) {
        userRepository.updateUserByIdAndLink(id, link);
    }

    @Transactional
    @Override
    public boolean deleteByIdAndPassword(Long id, String password) {
        return userRepository.deleteByIdAndPassword(id, password);
    }
}