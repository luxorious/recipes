package com.recipes.controller;

import com.recipes.dto.user.CreateUserDTO;
import com.recipes.dto.user.PrivateInfoUserDTO;
import com.recipes.dto.user.UserInfoDTO;
import com.recipes.service.interfaces.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public UserInfoDTO createUser(@Valid @RequestBody CreateUserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @GetMapping("/find-by-id/{id}")
    public PrivateInfoUserDTO getPrivateUserInfo(@PathVariable @Min(1) Long id){
        return userService.getPrivateUserInfo(id);
    }
}
