package com.recipes.controller;

import com.recipes.dto.authentication.AuthenticationDTO;
import com.recipes.dto.authentication.CreateAuthenticationDTO;
import com.recipes.dto.authentication.RestorePasswordDTO;
import com.recipes.service.crud.interfaces.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/create")
    public AuthenticationDTO createAuthentication(
            @Valid @RequestBody CreateAuthenticationDTO createAuthenticationDTO) {
        return authenticationService.createAuthentication(createAuthenticationDTO);
    }

    @GetMapping("/get-by-user/{userId}")
    public AuthenticationDTO getAuthenticationByUserId(@PathVariable Long userId) {
        return authenticationService.getAuthenticationByUserId(userId);
    }

    @PostMapping("/get-by-id/{id}")
    public AuthenticationDTO getAuthenticationByLogin(@PathVariable Long id) {
        return authenticationService.getAuthenticationById(id);
    }

    @PutMapping("/update-password-by-login")
    public AuthenticationDTO updateAuthenticationPasswordByLogin(
            @Valid @RequestBody RestorePasswordDTO passwordDTO) {
        return authenticationService.updateAuthenticationPasswordByLogin(passwordDTO);
    }

    @DeleteMapping("/delete-by-login-and-password")
    public boolean deleteAuthenticationByLoginAndPassword(
            @RequestParam String login, @RequestParam String password) {
        return authenticationService.deleteAuthenticationByLoginAndPassword(login, password);
    }
}
