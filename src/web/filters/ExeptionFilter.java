package web.filters;

import services.ServiceRuntimeExeption;
import web.command.servlet.FrontController;
import web.handlers.RequestHandler;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;

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
            RequestHandler.logger.warn("Error connecting to database", e);
            req.setAttribute("errorMsg", "Error connecting to database");

            try {
                req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
            } catch (ServletException e1) {
                RequestHandler.logger.error("Servlet error", e1);
            } catch (IOException e1) {
                RequestHandler.logger.error("Servlet error", e1);
            }

        } catch (RuntimeException e) {
            RequestHandler.logger.warn("Error input value", e);
            req.setAttribute("errorMsg", "Error input value");
            try {
                req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
            } catch (ServletException e1) {
                RequestHandler.logger.error("Servlet error", e1);
            } catch (IOException e1) {
                RequestHandler.logger.error("Servlet error", e1);
            }

        } catch (Exception e) {
            RequestHandler.logger.warn("Error getting the page", e);
            req.setAttribute("errorMsg", "Error getting the page");
            try {
                req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
            } catch (ServletException e1) {
                RequestHandler.logger.error("Servlet error", e1);
            } catch (IOException e1) {
                RequestHandler.logger.error("Servlet error", e1);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
