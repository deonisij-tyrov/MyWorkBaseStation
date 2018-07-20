package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static web.command.Controller.MAIN_PAGE;

@WebFilter(urlPatterns = {"/frontController"})
public class ExeptionFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            req.setAttribute("errorMsg", "error " + e.getMessage());
            System.out.println(e.getMessage());
            try {
                req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
            } catch (ServletException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
//            e.printStackTrace();
//            servletRequest.setAttribute("errorMessage", e.getMessage());
//            servletRequest.getRequestDispatcher(req.getContextPath() + "/frontController?command=stations").forward(servletRequest, servletResponse);

        }
    }

    @Override
    public void destroy() {

    }
}
