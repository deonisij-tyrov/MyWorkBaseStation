package web.command;

import services.ServiceRuntimeExeption;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by yslabko on 08/13/2017.
 */
public interface Controller {
    String MAIN_PAGE = "/WEB-INF/view/layouts/default.jsp";
//    NumberFormat numberFormat = NumberFormat.getNumberInstance();
    Locale locale = Locale.getDefault();
    ResourceBundle rb = ResourceBundle.getBundle("messages", locale);

    void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ServiceRuntimeExeption;
}
