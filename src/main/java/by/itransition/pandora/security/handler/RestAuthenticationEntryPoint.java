package by.itransition.pandora.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author i.katlinsky
 * @since 21.07.2016
 */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    {
        //TODO: remove this!
        System.out.println("--- RestAuthenticationEntryPoint -----!");
    }


    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response,
                         final AuthenticationException exception) throws IOException {

        System.out.println("--- RestAuthenticationEntryPoint | commence");

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
    }
}
