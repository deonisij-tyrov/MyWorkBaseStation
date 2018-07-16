package web.command.impl;

import entities.User;
import services.UserService;
import services.impl.UserServiceImpl;
import web.auth.Encoder;
import web.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegistrationUserController implements Controller {
    UserService userService = UserServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String userName = req.getParameter("username");
        String userLogin = req.getParameter("userlogin");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        if (userLogin == null || password1 == null || password2 == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            req.setAttribute("title", "Login form");
            dispatcher.forward(req, resp);
            return;
        }
        LocalDate date = LocalDate.parse(req.getParameter("userbirthday"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        User user = new User();
        if (password1.equals(password2)) {
            user.setName(userName);
            user.setPassword(Encoder.encode(password1));
            user.setLogin(userLogin);
            user.setDate(date);
            userService.save(user);
        }
        req.setAttribute("infoMsg", "Added new user");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
        dispatcher.forward(req, resp);
    }
}
