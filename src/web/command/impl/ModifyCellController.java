package web.command.impl;

import entities.Cell;
import services.CellService;
import services.impl.CellServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

public class ModifyCellController implements Controller {
    private CellService cellService = CellServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            String cellName = req.getParameter("cellname");
            Long cellId = numberFormat.parse(req.getParameter("cellid")).longValue();
            Integer cellSector = numberFormat.parse(req.getParameter("cellsector")).intValue();
            Integer cellPower = numberFormat.parse(req.getParameter("cellpower")).intValue();
            Long stationId = numberFormat.parse(req.getParameter("bsid")).longValue();
            Integer cellBand = numberFormat.parse(req.getParameter("cellband")).intValue();
            Cell modCell = new Cell(cellId, cellName, cellSector, cellPower, stationId, cellBand);
            cellService.update(modCell);
            req.setAttribute("infoMsg", "Set cell parameters " + modCell);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
