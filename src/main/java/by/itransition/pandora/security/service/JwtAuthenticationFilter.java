package by.itransition.pandora.security.service;

import by.itransition.pandora.security.handler.RestAuthenticationFailureHandler;
import by.itransition.pandora.security.model.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

/**
 * @author i.katlinsky
 * @since 21.07.2016
 */
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    {
        //TODO: remove this!
        System.out.println("--- JwtAuthenticationFilter -----!");
    }

    public JwtAuthenticationFilter(final AuthenticationManager authenticationManager) {
        super(request -> true);
        setAuthenticationManager(authenticationManager);
        setAuthenticationFailureHandler(new RestAuthenticationFailureHandler());
    }

    @Override
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response)
        throws IOException, ServletException {
        try {
            System.out.println("--- JwtAuthenticationFilter | attemptAuthentication -----!");

           /* Enumeration<String> nam = request.getHeaderNames();
            while(nam.hasMoreElements()){
                String h = nam.nextElement();
                System.out.println("- |" + h + " | " + request.getHeader(h));
            }
*/
            // Getting JWT token from request
            String token = Optional.ofNullable(request.getHeader(AuthenticationHelper.AUTHENTICATION_HEADER))
                    .map(header -> header.substring(7)).orElse(null);
            System.out.println("--- JwtAuthenticationFilter | token: " + token);

            if (Objects.isNull(token)) {
                System.out.println("--- JwtAuthenticationFilter | BadCredentialsException, token==null ");
                throw new BadCredentialsException("Token not found in request's header.");
            }

            // Create token for authentication provider
            JwtAuthenticationToken authRequest = new JwtAuthenticationToken(token);
            System.out.println("--- JwtAuthenticationFilter | authRequest: " + authRequest);

            Authentication auth = this.getAuthenticationManager().authenticate(authRequest);
            System.out.println("--- JwtAuthenticationFilter | auth: " + auth);


            // Return a fully authenticated object
            return auth;
        } catch (AuthenticationException exception) {
            // Go to 401 error page if exception thrown
            unsuccessfulAuthentication(request, response, exception);
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response,
                                            final FilterChain chain, final Authentication authResult)
        throws IOException, ServletException {
        System.out.println("--- JwtAuthenticationFilter | successfulAuthentication -----!");

        System.out.println("--- JwtAuthenticationFilter | authResult: " + authResult);
        // Set authentication to context
        SecurityContextHolder.getContext().setAuthentication(authResult);

        // Fire event
        if (this.eventPublisher != null) {
            this.eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(authResult, this.getClass()));
        }

        chain.doFilter(request, response);
    }
}
