package web.command.impl;

import entities.BaseStation;
import services.BaseStationService;
import services.CellService;

import services.impl.BaseStationServiceImpl;
import services.impl.CellServiceImpl;

import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yslabko on 08/13/2017.
 */
public class BaseStationController implements Controller {
    private CellService cellService = CellServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("products", cellService.getByBaseStation(new BaseStation(1,"test")));
        req.getSession().setAttribute("counter", 2);
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
