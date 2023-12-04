package com.recipes.converter.implementations;

import com.recipes.converter.interfaces.UserDTOConverter;
import com.recipes.dto.receipt.RecipeDTO;
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
public class UserDTOConverterImpl implements UserDTOConverter {

    private final ModelMapper mapper;

    @Override
    public UserInfoDTO toDtoUserInfo(User user) {
        UserInfoDTO userInfoDTO = mapper.map(user, UserInfoDTO.class);
        List<RecipeDTO> recipeDTOS = userInfoDTO.getRecipes();
        for (int i = 0; i < recipeDTOS.size(); i++) {
            //the algorithm needs to be improved, because now I am writing the same code twice
            recipeDTOS.get(i).setFirstName(user.getFirstName());
            recipeDTOS.get(i).setLastName(user.getLastName());
            recipeDTOS.get(i).setCategoryName(user.getRecipes().get(i).getCategory().getCategoryName());
            recipeDTOS.get(i).setCountryName(user.getRecipes().get(i).getCountry().getName());
        }
        return userInfoDTO;
    }

    @Override
    public User toEntity(CreateUserDTO userDTO) {
        return mapper.map(userDTO, User.class);
    }

    @Override
    public PrivateInfoUserDTO toDtoPrivateUserInfo(User user) {
        return mapper.typeMap(User.class, PrivateInfoUserDTO.class)
                .addMapping(us -> us.getAuthentication().getLogin(),
                        (infoDto, value) -> infoDto.setLogin((String) value))
                .addMapping(us -> us.getAuthentication().getRole(),
                        (infoDto, value) -> infoDto.setRole((String) value))
                .map(user);
    }

    @Override
    public List<UserInfoDTO> toListDto(List<User> users) {
        return users.stream()
                .map(this::toDtoUserInfo)
                .collect(Collectors.toList());
    }

}
