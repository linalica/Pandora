package by.itransition.pandora.security.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author i.katlinsky
 * @since 21.07.2016
 */
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    private static final String DENIED_MESSAGE = "Sorry, you don't have required permission for this operation.";

    @Override
    public void handle(final HttpServletRequest request, final HttpServletResponse response,
                       final AccessDeniedException exception) throws IOException {
        response.sendError(HttpServletResponse.SC_FORBIDDEN, DENIED_MESSAGE);
    }
}
