package by.itransition.pandora.security.model;

import by.itransition.pandora.model.User;
import by.itransition.pandora.repository.UserRepository;
import by.itransition.pandora.service.dto.exception.JsonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = this.userRepository.findByUsername(username);
        return Optional.ofNullable(byUsername)
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new JsonException("User nor found."));
    }
}
