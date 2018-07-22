package web.command.servlet;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.command.enums.CommandType;
import web.handlers.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Class FrontController
 * <p>
 * Created by yslabko on 08/11/2017.
 */
@WebServlet(urlPatterns = "/frontController")
public class FrontController extends HttpServlet {
    public static final Logger rootLogger = LogManager.getRootLogger();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, RuntimeException {
        CommandType commandType = RequestHandler.getCommand(req);
        commandType.getController().execute(req, resp);
    }
}
