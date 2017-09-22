package by.itransition.pandora.controller;

import by.itransition.pandora.model.User;
import by.itransition.pandora.repository.UserRepository;
import by.itransition.pandora.service.AuthenticationService;
import by.itransition.pandora.service.dto.model.AuthUserDto;
import by.itransition.pandora.service.dto.model.LoginRequestDto;
import by.itransition.pandora.service.dto.model.LoginResponseDto;
import by.itransition.pandora.service.transformer.AuthUserTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ikatlinsky
 * @since 5/12/17
 */
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthenticationController {


    /*@PostMapping(value = "/login")
    @ResponseStatus(value = HttpStatus.OK)
    public String login() {
        System.out.println("------ auth/login!  -----");
        return "Hi!";
    }*/

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthUserTransformer authUserTransformer;

/*
    @Autowired
    private SecurityContextHolder securityContextHolder;
*/

    @PostMapping(value = "/login")
    @ResponseStatus(value = HttpStatus.OK)
    public LoginResponseDto login(@RequestBody final LoginRequestDto loginRequestDto, HttpServletRequest httpServletRequest) {
        System.out.println("------ AuthenticationController | auth/login  -----");
        System.out.println("-- AuthenticationController | loginRequestDto " + loginRequestDto);
        HttpSession s = httpServletRequest.getSession();
        LoginResponseDto lrd = authenticationService.login(loginRequestDto);
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println("------ AuthenticationController | context in login: " + context);
        return lrd;
    }

    @GetMapping(value = "/me")
    @ResponseStatus(value = HttpStatus.OK)
    public AuthUserDto me( HttpServletRequest httpServletRequest) {
        System.out.println("------ AuthenticationController | auth/getMe  ----- ");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("------ AuthenticationController | auth: " + auth);
        UserDetails userDetails = null;
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            userDetails = (UserDetails) auth.getPrincipal();
        }
        System.out.println("------ AuthenticationController |  userDetails: " + userDetails);

        User user = userRepository.findByUsername(userDetails.getUsername());
        System.out.println("----- AuthenticationController |  user: " + user);

        return authUserTransformer.makeDto(user);

        //return authenticationService.getMe();
    }
}
