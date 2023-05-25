package test.restapi.cities.facade;


import test.restapi.cities.dto.authDto.AccessTokenDto;
import test.restapi.cities.dto.authDto.AuthDto;
import test.restapi.cities.dto.entityDto.UserDto;

public interface AuthFacade {
    AccessTokenDto getToken(AuthDto authDto);
    void saveUser(UserDto userDto);
}
