package web;


import entities.Cell;
import services.CellService;
import services.impl.CellServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cell")
public class ReadCell extends HttpServlet {
    private CellService cellService = CellServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long cellId;
        PrintWriter printWriter = resp.getWriter();
        if (req.getParameter("cell") != null) {
            cellId = Long.parseLong(req.getParameter("cell"));
        } else if (req.getSession().getAttribute("cell") != null) {
            cellId = (long) req.getSession().getAttribute("cell");
        } else {
            printWriter.print("Not Found param");
            return;
        }
        Cell cell = cellService.get(cellId);
//        Cell cell = new Cell(1,"test", 1,400,1000,3);
        printWriter.print("<html>\n<head>\n<title>Cookie test</title></head>\n" +
                "  <body>cell");
        printWriter.print(cell.toString());
        printWriter.print("</body></html>");
    }
}
