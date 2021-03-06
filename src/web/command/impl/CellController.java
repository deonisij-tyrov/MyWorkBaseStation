package web.command.impl;

import services.CellService;
import services.ServiceRuntimeExeption;
import services.impl.CellServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CellController implements Controller {
    private CellService cellService = CellServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServiceRuntimeExeption {
        Long baseStationId = Long.parseLong(req.getParameter("stationid"));
        req.getSession().setAttribute("stationid", baseStationId.toString());
        req.getSession().setAttribute("cells", cellService.getByBaseStationId(baseStationId));
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
