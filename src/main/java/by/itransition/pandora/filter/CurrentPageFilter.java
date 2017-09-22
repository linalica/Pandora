package by.itransition.pandora.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.InputStreamReader;

@WebFilter(filterName = "CurrentPageFilter", urlPatterns = {"/*"})
public class CurrentPageFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--- CurrentPageFilter -----");
        try {
            System.out.println("reader request: ");
            InputStreamReader reader = new InputStreamReader(servletRequest.getInputStream());
            int c;
            while ((c = reader.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("reader ex");
        }
        System.out.println("reader END: ");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
