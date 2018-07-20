package web.command.impl;

import services.BaseStationService;
import services.impl.BaseStationServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by yslabko on 08/13/2017.
 */
public class BaseStationController implements Controller {
    private final int COUNT_BASE_STATIONS = 10;
    private BaseStationService baseStationService = BaseStationServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer pageNumber = numberFormat.parse(req.getParameter("stationspage")).intValue();
            int from = pageNumber * COUNT_BASE_STATIONS - COUNT_BASE_STATIONS;
            req.getSession().setAttribute("stations", baseStationService.getSomeTen(from, COUNT_BASE_STATIONS));
            req.setAttribute("currentPage", pageNumber);
            req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
