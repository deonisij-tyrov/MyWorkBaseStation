package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/frontController"})
public class ExeptionFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            req.setAttribute("errorMsg", "error " + e.getMessage());
//            e.printStackTrace();
//            servletRequest.setAttribute("errorMessage", e.getMessage());
//            servletRequest.getRequestDispatcher(req.getContextPath() + "/frontController?command=stations").forward(servletRequest, servletResponse);

        }
    }

    @Override
    public void destroy() {

    }
}
