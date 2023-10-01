package com.recipes.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListDTO {
    private List<UserInfoDTO> ListUserDTO;
}
