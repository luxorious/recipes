package com.recipes.controller;

import com.recipes.dto.authentication.CreateAuthenticationDTO;
import com.recipes.service.interfaces.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;


    @PostMapping("/create")
    public ResponseEntity<String> createAuthentication(@Valid @RequestBody CreateAuthenticationDTO createAuthenticationDTO){
        log.info(createAuthenticationDTO.toString()+"helllo");
//        return authenticationService.createAuthentication(createAuthenticationDTO);
        return ResponseEntity.ok("User is valid");
    }

}
