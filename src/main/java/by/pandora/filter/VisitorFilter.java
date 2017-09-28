package by.pandora.filter;

import by.pandora.controller.ControllerConstants;
import by.pandora.model.Visitor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;



@WebFilter(filterName = "VisitorFilter",  urlPatterns = {"/views/*"})
public class VisitorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        initUserState(request);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void initUserState(HttpServletRequest req) {
        Visitor visitor = (Visitor)req.getSession().getAttribute(ControllerConstants.VISITOR_KEY);
        if (visitor == null) {
            visitor = new Visitor();
            visitor.setLocale(ControllerConstants.DEFAULT_LOCALE);
            visitor.setTheme(ControllerConstants.DEFAULT_THEME);
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
