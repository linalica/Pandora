package by.itransition.pandora.filter;

import by.itransition.pandora.controller.ControllerConstants;
import by.itransition.pandora.model.Visitor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

<<<<<<< HEAD
=======


>>>>>>> new-start
@WebFilter(filterName = "VisitorFilter",  urlPatterns = {"/views/*"})
public class VisitorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
<<<<<<< HEAD
        System.out.println("------- VisitorFilter -------- ");
=======
>>>>>>> new-start
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        initUserState(request);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void initUserState(HttpServletRequest req) {
        Visitor visitor = (Visitor)req.getSession().getAttribute(ControllerConstants.VISITOR_KEY);
        if (visitor == null) {
            visitor = new Visitor();
            visitor.setLocale(ControllerConstants.DEFAULT_LOCALE);
<<<<<<< HEAD
            //visitor.setTheme(ControllerConstants.DEFAULT_LOCALE);
=======
            visitor.setTheme(ControllerConstants.DEFAULT_THEME);
>>>>>>> new-start
            req.getSession().setAttribute(ControllerConstants.VISITOR_KEY, visitor);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
