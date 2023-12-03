package com.recipes.controller;

import com.recipes.dto.user.CreateUserDTO;
import com.recipes.dto.user.PrivateInfoUserDTO;
import com.recipes.dto.user.UserInfoDTO;
import com.recipes.service.crud.interfaces.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public UserInfoDTO createUser(@Valid @RequestBody CreateUserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping("/find-by-id/{id}")
    public PrivateInfoUserDTO getPrivateUserInfo(@PathVariable Long id) {
        return userService.getPrivateUserInfo(id);
    }

    @GetMapping("/all")
    public List<UserInfoDTO> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/find-by-name")
    public List<UserInfoDTO> findByName(@RequestParam String name) {
        return userService.findByName(name);
    }

    @PutMapping("update-first-name/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserByIdAndFirstName(
            @PathVariable Long id, @RequestParam String firstName) {
        userService.updateUserByIdAndFirstName(id, firstName);
    }

    @PutMapping("update-last-name/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserByIdAndLastName(
            @PathVariable Long id, @RequestParam String lastName) {
        userService.updateUserByIdAndLastName(id, lastName);
    }

    @PutMapping("update-e-mail/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserByIdAndEMail(
            @PathVariable Long id, @RequestParam String eMail) {
        userService.updateUserByIdAndEMail(id, eMail);
    }

    @PutMapping("update-about-me/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserByIdAndAboutMe(
            @PathVariable Long id, @RequestParam String aboutMe) {
        userService.updateUserByIdAndAboutMe(id, aboutMe);
    }
    @PutMapping("update-skills/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserByIdAndSkills(
            @PathVariable Long id, @RequestParam String skills) {
        userService.updateUserByIdAndSkills(id, skills);
    }
    @PutMapping("update-link/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserByIdAndLink(
            @PathVariable Long id, @RequestParam String link) {
        userService.updateUserByIdAndLink(id, link);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteByIdAndPassword(
            @PathVariable Long id, @RequestParam String password) {
        return userService.deleteByIdAndPassword(id, password);
    }
}
