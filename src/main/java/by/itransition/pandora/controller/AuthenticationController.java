package by.itransition.pandora.controller;

import by.itransition.pandora.service.AuthenticationService;
import by.itransition.pandora.service.dto.AuthUserDto;
import by.itransition.pandora.service.dto.LoginRequestDto;
import by.itransition.pandora.service.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author ikatlinsky
 * @since 5/12/17
 */
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthenticationController {


    private AuthenticationService authenticationService;

    @PostMapping(value = "/login")
    @ResponseStatus(value = HttpStatus.OK)
    public LoginResponseDto login(@RequestBody final LoginRequestDto loginRequestDto) {
        System.out.println("--LOGIN!!");
        return authenticationService.login(loginRequestDto);
    }

    @GetMapping(value = "/me")
    @ResponseStatus(value = HttpStatus.OK)
    public AuthUserDto me() {
        return authenticationService.getMe();
    }
}
