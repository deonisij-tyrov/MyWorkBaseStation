package web.command.impl;

import services.BaseStationService;
import services.impl.BaseStationServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yslabko on 08/13/2017.
 */
public class BaseStationController implements Controller {
    private BaseStationService baseStationService = BaseStationServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("stations", baseStationService.getAll());
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
