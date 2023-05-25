package test.restapi.cities.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.restapi.cities.dto.authDto.AccessTokenDto;
import test.restapi.cities.dto.authDto.AuthDto;
import test.restapi.cities.dto.entityDto.UserDto;
import test.restapi.cities.facade.AuthFacade;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class AuthController {

    private final AuthFacade authFacade;

    @PostMapping("/auth")
    public ResponseEntity<AccessTokenDto> loginWithNameAndPassword(@RequestBody @Valid AuthDto authDto) {
        return new ResponseEntity<>(authFacade.getToken(authDto), HttpStatus.OK);
    }

    @PostMapping("/registering")
    public ResponseEntity saveUser(@RequestBody @Valid UserDto userDto) {
        authFacade.saveUser(userDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
