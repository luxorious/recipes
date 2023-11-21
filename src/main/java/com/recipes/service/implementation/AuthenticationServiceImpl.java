package com.recipes.service.implementation;

import com.recipes.converter.AuthenticationDTOConverter;
import com.recipes.dto.authentication.AuthenticationDTO;
import com.recipes.dto.authentication.CreateAuthenticationDTO;
import com.recipes.entity.Authentication;
import com.recipes.repository.AuthenticationRepository;
import com.recipes.service.component.interfaces.NullChecker;
import com.recipes.service.interfaces.AuthenticationService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Data
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationRepository repository;
    private final AuthenticationDTOConverter authenticationDTOConverter;
    private final NullChecker<Authentication> nullChecker;

    @Transactional
    @Override
    public AuthenticationDTO createAuthentication(CreateAuthenticationDTO createAuthenticationDTO) {
        Authentication auth = authenticationDTOConverter.toEntity(createAuthenticationDTO);
        auth = repository.save(auth);
        return authenticationDTOConverter.toDto(auth);
    }

    @Transactional
    @Override
    public AuthenticationDTO getAuthenticationByUserId(Long userId) {
        Authentication authentication = nullChecker.entity(repository.findByUserId(userId));
        return authenticationDTOConverter.toDto(authentication);
    }

    @Transactional
    @Override
    public AuthenticationDTO getAuthenticationById(Long id) {
        Authentication authentication = nullChecker.entity(repository.getAuthenticationById(id));
        return authenticationDTOConverter.toDto(authentication);
    }

    @Transactional
    @Override
    public AuthenticationDTO updateAuthenticationPasswordByLogin(String login, String newPassword) {
        return authenticationDTOConverter.toDto(repository.updatePasswordByLogin(login, newPassword));
    }

    @Transactional
    @Override
    public boolean deleteAuthenticationByLoginAndPassword(String login, String password) {
        return repository.deleteByLoginAndPassword(login, password);
    }
}
