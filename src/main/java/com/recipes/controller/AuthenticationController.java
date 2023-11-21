package com.recipes.controller;

import com.recipes.dto.authentication.AuthenticationDTO;
import com.recipes.dto.authentication.CreateAuthenticationDTO;
import com.recipes.service.interfaces.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/create")
    public AuthenticationDTO createAuthentication(@Valid @RequestBody CreateAuthenticationDTO createAuthenticationDTO) {
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
            @RequestParam String login, @RequestParam String newPassword) {
        return authenticationService.updateAuthenticationPasswordByLogin(login, newPassword);
    }

    @DeleteMapping("/delete-by-login-and-password")
    public boolean deleteAuthenticationByLoginAndPassword(
            @RequestParam String login, @RequestParam String password) {
        return authenticationService.deleteAuthenticationByLoginAndPassword(login, password);
    }
}
