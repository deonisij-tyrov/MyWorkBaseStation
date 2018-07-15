package web.handlers;

import web.command.enums.CommandType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static web.command.enums.CommandType.LOGIN;

/**
 * Created by yslabko on 08/13/2017.
 */
public class RequestHandler {

    public static CommandType getCommand(HttpServletRequest req) {
        String param = req.getParameter("command");
        if (param == null || "".equals(param)) {
            param = "login";
        }


        CommandType type = CommandType.getByPageName(param);
        req.setAttribute("title", type.getPageName());
        HttpSession session = req.getSession();
        String pageName = (String) session.getAttribute("pageName");
        if (pageName != null) {
            session.setAttribute("prevPage", pageName);
            session.setAttribute("pageName", type.getPageName());
            session.setAttribute("pagePath", type.getPagePath());
        } else {
            session.setAttribute("prevPage", type.getPageName());
            session.setAttribute("pageName", LOGIN.getPageName());
            session.setAttribute("pagePath", LOGIN.getPagePath());
        }

        return type;
    }
}
