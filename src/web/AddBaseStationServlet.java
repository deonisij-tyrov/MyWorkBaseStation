package web;

import entities.BaseStation;
import services.BaseStationService;
import services.impl.BaseStationServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addstation")
public class AddBaseStationServlet extends HttpServlet {
    BaseStationService baseStationService = BaseStationServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/addstation.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String baseStationname = req.getParameter("bs_name");
        long baseStationId = Long.parseLong(req.getParameter("bs_id"));
        baseStationService.save(new BaseStation(baseStationId, baseStationname));
    }
}
