package web.command.impl;

import entities.Cell;
import services.CellService;
import services.ServiceRuntimeExeption;
import services.impl.CellServiceImpl;
import web.command.Controller;
import web.handlers.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyCellController implements Controller {
    private CellService cellService = CellServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ServiceRuntimeExeption {
        System.out.println("delete" + req.getAttribute("delete"));
        System.out.println("chenge" + req.getAttribute("chenge"));
        String cellName = req.getParameter("cellname");
        Long cellId = Long.parseLong(req.getParameter("cellid"));
        Integer cellSector = Integer.parseInt(req.getParameter("cellsector"));
        Integer cellPower = Integer.parseInt(req.getParameter("cellpower"));
        Long stationId = Long.parseLong(req.getParameter("bsid"));
        Integer cellBand = Integer.parseInt(req.getParameter("cellband"));
        Cell modCell = new Cell(cellId, cellName, cellSector, cellPower, stationId, cellBand);
        cellService.update(modCell);
        RequestHandler.logger.info("Set cell parameters " + modCell);
        req.setAttribute("infoMsg", "Set cell parameters " + modCell);
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
