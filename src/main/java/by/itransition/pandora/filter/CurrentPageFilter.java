package by.itransition.pandora.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CurrentPageFilter", urlPatterns = {"/views/*"},
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class CurrentPageFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
<<<<<<< HEAD
=======
        //System.out.println("---- CurrentPageFilter");
>>>>>>> new-start
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
<<<<<<< HEAD

=======
>>>>>>> new-start
    }

    @Override
    public void destroy() {
<<<<<<< HEAD

    }

=======
    }
>>>>>>> new-start
}
