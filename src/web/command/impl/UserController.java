package web.command.impl;

import entities.User;
import services.ServiceRuntimeExeption;
import services.UserService;
import services.impl.UserServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController implements Controller {
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ServiceRuntimeExeption {
        if (!((User) req.getSession().getAttribute("user")).getRole().equalsIgnoreCase("ADMIN")) {
            req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
            return;
        }
        String userId = req.getParameter("userid");
        if (userId != null) {
            String userStatus = req.getParameter("userstatus");
            if (userStatus.equalsIgnoreCase("ACTIVE")) {
                userService.setStatusUser(Integer.parseInt(userId), "INACTIVE");
            } else {
                userService.setStatusUser(Integer.parseInt(userId), "ACTIVE");
            }
        }
        req.setAttribute("users", userService.readAll());
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
