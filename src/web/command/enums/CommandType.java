package web.command.enums;


import web.command.Controller;
import web.command.impl.*;


public enum CommandType {
    LOGIN("login.jsp", "login", new LoginController()),
    LOGOUT("login.jsp", "logout", new LogoutController()),
    BASE_STATION("stations/main.jsp", "stations", new BaseStationController()),
    GET_CELL("cells/main.jsp", "cells", new CellController()),
    ADD_CELL("cells/setcell.jsp", "addcell", new AddCellController()),
    REMOVE_CELL("cells/setcell.jsp", "removecell", new RemoveCellController()),
    SET_CELL("cells/setcell.jsp", "setcell", new ModifyCellController()),
    GET_USER("user/main.jsp", "users", new UserController()),
    REGISTRATION("registration.jsp", "registration", new RegistrationUserController());

    private String pagePath;
    private String pageName;
    private Controller controller;


    CommandType(String pagePath, String pageName, Controller controller) {
        this.pagePath = pagePath;
        this.pageName = pageName;
        this.controller = controller;
    }

    public static CommandType getByPageName(String page) {
        for (CommandType type : CommandType.values()) {
            if (type.pageName.equalsIgnoreCase(page)) {
                return type;
            }
        }
// Если ничего не найдено, то на главную страницу с логином
        return LOGIN;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
