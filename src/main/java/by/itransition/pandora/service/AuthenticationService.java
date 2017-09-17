/*
package by.itransition.pandora.service;

import by.itransition.pandora.repository.UserRepository;
import by.itransition.pandora.service.transformer.AuthUserTransformer;
import com.spring.jwt.model.User;
import com.spring.jwt.repository.UserRepository;
import com.spring.jwt.security.SecurityHelper;
import com.spring.jwt.security.model.JwtUserDetails;
import com.spring.jwt.security.service.AuthenticationHelper;
import com.spring.jwt.service.dto.AuthUserDto;
import com.spring.jwt.service.dto.JsonException;
import com.spring.jwt.service.dto.LoginRequestDto;
import com.spring.jwt.service.dto.LoginResponseDto;
import com.spring.jwt.service.transformer.AuthUserTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.net.www.protocol.http.AuthenticationHeader;

import java.util.Objects;
import java.util.Optional;

*/
/**
 * @author ikatlinsky
 * @since 5/12/17
 *//*

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  AuthUserTransformer authUserTransformer;

    @Autowired
    private A authenticationHelper;

    @Autowired
    private  AuthenticationManager authenticationManager;

    public LoginResponseDto login(final LoginRequestDto loginRequestDto) {
        try {
            String username = Optional.ofNullable(loginRequestDto.getUsername())
                    .orElseThrow(() -> new BadCredentialsException("Username should be passed."));

            String password = Optional.ofNullable(loginRequestDto.getPassword())
                    .orElseThrow(() -> new BadCredentialsException("Password should be passed."));

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username,
                    password);

            // Try to authenticate with this token
            final Authentication authResult = this.authenticationManager.authenticate(authRequest);

            // Set generated JWT token to response header
            if (authResult.isAuthenticated()) {
                JwtUserDetails userDetails = (JwtUserDetails) authResult.getPrincipal();

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

    */
/**
     * Get user info.
     * @return user info.
     *//*

    @Transactional(readOnly = true)
    public AuthUserDto getMe() {
        Authentication authentication = SecurityHelper.getAuthenticationWithCheck();
        User byUsername = userRepository.findByUsername(authentication.getName());

        return authUserTransformer.makeDto(byUsername);
    }
}
*/
