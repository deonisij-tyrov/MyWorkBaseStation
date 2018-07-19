package web.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Created by yslabko on 08/13/2017.
 */
public interface Controller {
    String MAIN_PAGE = "/WEB-INF/view/layouts/default.jsp";
    NumberFormat numberFormat = NumberFormat.getNumberInstance();

    void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
}
