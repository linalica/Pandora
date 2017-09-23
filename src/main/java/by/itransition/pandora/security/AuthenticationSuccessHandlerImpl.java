package by.itransition.pandora.security;

import by.itransition.pandora.controller.ControllerConstants;
import by.itransition.pandora.model.User;
import by.itransition.pandora.model.Visitor;
import by.itransition.pandora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        if (authentication != null) {
            User user = userService.findByUsername(authentication.getName());
            Visitor visitor = (Visitor) request.getSession().getAttribute(ControllerConstants.VISITOR_KEY);
            visitor.setTheme(user.getTheme());
            visitor.setLocale(user.getLocale());
        }
        response.sendRedirect("main");
    }
}
