package web.command.impl;

import entities.User;
import services.UserService;
import services.impl.UserServiceImpl;
import web.auth.Encoder;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class
RegistrationUserController implements Controller {
    UserService userService = UserServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String userName = req.getParameter("username");
        String userLogin = req.getParameter("userlogin");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        if (userName == null || userLogin == null || password1 == null || password2 == null) {
            req.setAttribute("infoMsg", "Fill in all the fields");
            req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
            return;
        }

        if (userService.getByLogin(userName) != null) {
            req.setAttribute("infoMsg", "User with this login already exists");
            req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
            return;
        }

        if (password1.equals(password2)) {
            LocalDate date = LocalDate.parse(req.getParameter("userbirthday"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            User user = new User();
            user.setName(userName);
            user.setPassword(Encoder.encode(password1));
            user.setLogin(userLogin);
            user.setDate(date);
            userService.save(user);
            req.setAttribute("infoMsg", "Added new user");
        } else {
            req.setAttribute("infoMsg", "Passwords do not match");
        }
        req.getRequestDispatcher(req.getContextPath() + "/frontController?command=login").forward(req, resp);
    }
}
