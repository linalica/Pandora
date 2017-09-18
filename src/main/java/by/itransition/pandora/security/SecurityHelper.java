package by.itransition.pandora.security;

import by.itransition.pandora.service.dto.exception.JsonException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author ikatlinsky
 * @since 5/12/17
 */
public class SecurityHelper {

    //todo:
    public static Authentication getAuthenticationWithCheck() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("-- SecurityHelper | authentication.getDetails: " + authentication.getDetails());
        boolean checkAuthenticationExists = authentication != null && authentication.isAuthenticated();
        if (checkAuthenticationExists) {
            return authentication;
        }
        throw new JsonException("Authentication failed.");
    }
}
