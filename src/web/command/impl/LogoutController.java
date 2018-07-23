package web.command.impl;

import com.sun.javafx.binding.StringFormatter;
import web.command.Controller;
import web.handlers.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutController implements Controller {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestHandler.logger.info(String.format("User %s exit",req.getSession().getAttribute("user")));
        req.getSession().invalidate();
        req.getServletContext().getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
