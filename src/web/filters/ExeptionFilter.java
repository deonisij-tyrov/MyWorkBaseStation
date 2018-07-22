package web.filters;

import services.ServiceRuntimeExeption;
import web.command.servlet.FrontController;

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
        } catch (ServiceRuntimeExeption e) {
            FrontController.rootLogger.catching(e);
            req.setAttribute("errorMsg", "Error connecting to database");
            try {
                req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
            } catch (ServletException e1) {
                FrontController.rootLogger.catching(e1);
            } catch (IOException e1) {
                FrontController.rootLogger.catching(e1);
            }
        } catch (RuntimeException e) {
            FrontController.rootLogger.catching(e);
            req.setAttribute("errorMsg", "Error input value");
            try {
                req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
            } catch (ServletException e1) {
                FrontController.rootLogger.catching(e1);
            } catch (IOException e1) {
                FrontController.rootLogger.catching(e1);
            }
        } catch (Exception e) {
            FrontController.rootLogger.catching(e);
            req.setAttribute("errorMsg", "Error getting the page");
            try {
                req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
            } catch (ServletException e1) {
                FrontController.rootLogger.catching(e1);
            } catch (IOException e1) {
                FrontController.rootLogger.catching(e1);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
