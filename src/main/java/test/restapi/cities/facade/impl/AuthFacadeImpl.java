package test.restapi.cities.facade.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.restapi.cities.dto.authDto.AccessTokenDto;
import test.restapi.cities.dto.authDto.AuthDto;
import test.restapi.cities.dto.entityDto.UserDto;
import test.restapi.cities.facade.AuthFacade;
import test.restapi.cities.mapper.UserMapper;
import test.restapi.cities.service.AuthService;

@Component
@AllArgsConstructor
public class AuthFacadeImpl implements AuthFacade {

    private final AuthService authService;
    private final UserMapper mapper;

    @Override
    public AccessTokenDto getToken(AuthDto authDto) {
        return new AccessTokenDto(authService.loginWithUsernameAndPassword(authDto.getUsername(), authDto.getPassword()));
    }

    @Override
    public void saveUser(UserDto userDto) {
        authService.saveUser(mapper.toEntity(userDto));
    }
}
