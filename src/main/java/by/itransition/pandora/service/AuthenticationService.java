package by.itransition.pandora.service;

import by.itransition.pandora.model.User;
import by.itransition.pandora.repository.UserRepository;
import by.itransition.pandora.security.model.CustomUserDetails;
import by.itransition.pandora.service.dto.exception.JsonException;
import by.itransition.pandora.service.dto.model.LoginRequestDto;
import by.itransition.pandora.service.dto.model.LoginResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */
@Service
public class AuthenticationService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private  AuthenticationHelper authenticationHelper;

    public LoginResponseDto login(final LoginRequestDto loginRequestDto) {
        try {
            String username = Optional.ofNullable(loginRequestDto.getUsername())
                    .orElseThrow(() -> new BadCredentialsException("Username should be passed."));

            String password = Optional.ofNullable(loginRequestDto.getPassword())
                    .orElseThrow(() -> new BadCredentialsException("Password should be passed."));

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username,
                    password);

            // Try to authenticate with this token
            final Authentication authentication = this.authenticationManager.authenticate(authRequest);

            // Set generated JWT token to response header
            if (authentication.isAuthenticated()) {
                CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

                User user = userRepository.findOne(userDetails.getId());
                if (Objects.isNull(user)) {
                    throw new JsonException("User not exist in system.");
                }

                String token = this.authenticationHelper.generateToken(userDetails.getId());
                return new LoginResponseDto(token);

            } else {
                throw new JsonException("Authentication failed.");
            }

        } catch (BadCredentialsException exception) {
            throw new JsonException("Username or password was incorrect. Please try again.", exception);
        }
    }


}
