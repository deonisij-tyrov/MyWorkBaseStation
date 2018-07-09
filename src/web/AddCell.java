package web;

import entities.Cell;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddCell extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<html>" +
                "<body>" +
                "<form action='add' method='post'>" +
                "<input type='text' name='name'/>" +
                "<input type='text' name='sector'/>" +
                "<input type='text' name='power'/>" +
                "<input type='text' name='bsNumber'/>" +
                "<input type='text' name='band'/>" +
                "<input type='submit' name='submit'/>" +
                "</body>" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int sector = Integer.parseInt(req.getParameter("sector"));
        int power = Integer.parseInt(req.getParameter("power"));
        int bsNumber = Integer.parseInt(req.getParameter("bsNumber"));
        int band = Integer.parseInt(req.getParameter("band"));
        System.out.println(new Cell(name, sector, power, bsNumber, band).toString());
        doGet(req,resp);
    }
}
