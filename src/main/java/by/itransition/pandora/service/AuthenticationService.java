package by.itransition.pandora.service;

import by.itransition.pandora.model.User;
import by.itransition.pandora.model.UserRole;
import by.itransition.pandora.repository.UserRepository;
import by.itransition.pandora.security.SecurityHelper;
import by.itransition.pandora.security.model.JwtUserDetails;
import by.itransition.pandora.security.service.AuthenticationHelper;
import by.itransition.pandora.service.dto.exception.JsonException;
import by.itransition.pandora.service.dto.model.AuthUserDto;
import by.itransition.pandora.service.dto.model.LoginRequestDto;
import by.itransition.pandora.service.dto.model.LoginResponseDto;
import by.itransition.pandora.service.transformer.AuthUserTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
//@Transactional
@RequiredArgsConstructor
public class AuthenticationService {

    //TODO: clean class

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final AuthUserTransformer authUserTransformer;

    @Autowired
    private final AuthenticationHelper authenticationHelper;

    @Autowired
    private final AuthenticationManager authenticationManager;

    public LoginResponseDto login(final LoginRequestDto loginRequestDto) {
        try {
            System.out.println("-- AuthenticationManager | login");
/*            System.out.println("-- AuthenticationManager | userRepository:  " + userRepository);
            System.out.println("-- AuthenticationManager | authUserTransformer:  " + authUserTransformer);
            System.out.println("-- AuthenticationManager | authenticationHelper:  " + authenticationHelper);
            System.out.println("-- AuthenticationManager | authenticationManager:  " + authenticationManager);*/

            String username = Optional.ofNullable(loginRequestDto.getUsername()).orElseThrow(() -> new BadCredentialsException("Username should be passed."));
            String password = Optional.ofNullable(loginRequestDto.getPassword()).orElseThrow(() -> new BadCredentialsException("Password should be passed."));

            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(UserRole.ROLE_USER.name()));

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);

            System.out.println("-- AuthenticationManager | 3 " + authRequest);
            System.out.println("-- AuthenticationManager | 3 " + authRequest.getCredentials());
            System.out.println("-- AuthenticationManager | 3 " + authRequest.getPrincipal());

            // Try to authenticate with this token
            Authentication authResult = this.authenticationManager.authenticate(authRequest);
            SecurityContextHolder.getContext().setAuthentication(authResult);
            System.out.println("-- AuthenticationManager | 4 authResult: " + authRequest );
            System.out.println("-- AuthenticationManager | 4 getAuthentication: " + SecurityContextHolder.getContext().getAuthentication());


            // Set generated JWT token to response header
            if (authResult.isAuthenticated()) {
                System.out.println("-- AuthenticationManager | 5");
                JwtUserDetails userDetails = (JwtUserDetails) authResult.getPrincipal();
                User user = userRepository.findOne(userDetails.getId());
                if (Objects.isNull(user)) {
                    throw new JsonException("User not exist in system.");
                }
                String token = this.authenticationHelper.generateToken(userDetails.getId());
                System.out.println("-- AuthenticationManager | 8");
                return new LoginResponseDto(token);
            } else {
                System.out.println("-- AuthenticationManager | 9 Authentication failed");
                throw new JsonException("Authentication failed.");
            }

        } catch (BadCredentialsException e) {
            System.out.println("-- AuthenticationManager | 10 - cant find User" );
            throw new JsonException("Username or password was incorrect. Please try again.", e);
        }
    }

    /**
     * Get user info.
     *
     * @return user info.
     */
    //@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public AuthUserDto getMe() {

        System.out.println("-- AuthenticationManager | getMe");
        Authentication authentication = SecurityHelper.getAuthenticationWithCheck();

        System.out.println("-- AuthenticationManager | authentication: " + authentication);
        User byUsername = userRepository.findByUsername(authentication.getName());

        System.out.println("-- AuthenticationManager | byUsername: " + byUsername);

        return authUserTransformer.makeDto(byUsername);
    }
}
