package web.command.impl;

import services.CellService;
import services.ServiceRuntimeExeption;
import services.impl.CellServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveCellController implements Controller {
    private CellService cellService = CellServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ServiceRuntimeExeption {
        Long cellId = Long.parseLong(req.getParameter("cellid"));
        cellService.delete(cellId);
        req.setAttribute("infoMsg", "Removed cell " + cellId);
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
