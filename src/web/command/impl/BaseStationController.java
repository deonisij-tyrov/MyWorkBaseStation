package web.command.impl;

import services.BaseStationService;
import services.ServiceRuntimeExeption;
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
    private final int NUMBER_OF_STATIONS_PER_PAGE = 15;
    private BaseStationService baseStationService = BaseStationServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServiceRuntimeExeption {
        req.setAttribute("maxPage", Math.ceil((double) baseStationService.count() / NUMBER_OF_STATIONS_PER_PAGE));
        Integer pageNumber = Integer.parseInt(req.getParameter("stationspage"));
        int fromRecording = pageNumber * NUMBER_OF_STATIONS_PER_PAGE - NUMBER_OF_STATIONS_PER_PAGE;
        req.getSession().setAttribute("stations", baseStationService.getPartOfStations(fromRecording, NUMBER_OF_STATIONS_PER_PAGE));
        req.setAttribute("currentPage", pageNumber);
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
