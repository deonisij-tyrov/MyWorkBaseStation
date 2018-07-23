package web.command.impl;

import entities.User;
import services.ServiceRuntimeExeption;
import services.UserService;
import services.impl.UserServiceImpl;
import web.auth.Encoder;
import web.command.Controller;
import web.handlers.RequestHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginController implements Controller {
    UserService userService = UserServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ServiceRuntimeExeption {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login == null || password == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            req.setAttribute("title", "Login form");
            dispatcher.forward(req, resp);
            return;
        }
        User user = userService.getByLogin(login);
        if (user != null && user.getPassword().equals(Encoder.encode(password))) {
            req.getSession().setAttribute("user", user);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/frontController?command=stations&stationspage=1");
            RequestHandler.logger.info(String.format("User %s login",req.getSession().getAttribute("user")));
            return;
        } else {
            RequestHandler.logger.info(String.format(rb.getString("login.errorpassword")));
            req.setAttribute("errorMsg", rb.getString("login.errorpassword"));
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            req.setAttribute("title", "Login form");
            dispatcher.forward(req, resp);
            return;
        }
    }
}
