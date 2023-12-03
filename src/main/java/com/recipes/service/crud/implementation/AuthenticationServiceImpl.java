package com.recipes.service.crud.implementation;

import com.recipes.converter.interfaces.AuthenticationDTOConverter;
import com.recipes.dto.authentication.AuthenticationDTO;
import com.recipes.dto.authentication.CreateAuthenticationDTO;
import com.recipes.dto.authentication.RestorePasswordDTO;
import com.recipes.entity.Authentication;
import com.recipes.repository.AuthenticationRepository;
import com.recipes.service.crud.interfaces.AuthenticationService;
import com.recipes.service.nullсhecker.NullChecker;
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
    public AuthenticationDTO updateAuthenticationPasswordByLogin(RestorePasswordDTO passwordDTO) {
        Authentication auth = nullChecker.entity(repository.findByLogin(passwordDTO.getLogin()));
        if (auth.getUser().getEMail().equals(passwordDTO.getEMail())){
            return authenticationDTOConverter.toDto(
                    repository.updatePasswordByLogin(
                            passwordDTO.getLogin(), passwordDTO.getNewPassword()));
        } else {
            throw new IllegalArgumentException("You have not permission");
        }
    }

    @Transactional
    @Override
    public boolean deleteAuthenticationByLoginAndPassword(String login, String password) {
        return repository.deleteByLoginAndPassword(login, password);
    }
}
