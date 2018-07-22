package web.command.impl;

import entities.Cell;
import services.CellService;
import services.ServiceRuntimeExeption;
import services.impl.CellServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCellController implements Controller {
    private CellService cellService = CellServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ServiceRuntimeExeption {
        String cellName = req.getParameter("cellname");
        Integer cellSector = Integer.parseInt(req.getParameter("cellsector"));
        Integer cellPower = Integer.parseInt(req.getParameter("cellpower"));
        Long stationId = Long.parseLong(req.getParameter("bsid"));
        Integer cellBand = Integer.parseInt(req.getParameter("cellband"));
        Cell addCell = new Cell(cellName, cellSector, cellPower, stationId, cellBand);
        addCell = cellService.save(addCell);
        req.setAttribute("infoMsg", "Set cell parameters " + addCell);
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
