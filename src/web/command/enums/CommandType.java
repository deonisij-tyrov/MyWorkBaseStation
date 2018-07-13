package web.command.enums;


import web.command.Controller;
import web.command.impl.LoginController;
import web.command.impl.LogoutController;

import web.command.impl.BaseStationController;

/**
 * Created by yslabko on 08/13/2017.
 */

public enum CommandType {
    LOGIN("login.jsp", "Login", new LoginController()),
    LOGOUT("login.jsp", "Logout", new LogoutController()),
//    ORDERS("orders/main.jsp", "Orders", new OrderController()),
    PRODUCTS("products/main.jsp", "Products", new BaseStationController());

    private String pagePath;
    private String pageName;
    private Controller controller;

    public static CommandType getByPageName(String page) {
        for (CommandType type : CommandType.values()) {
            if (type.pageName.equalsIgnoreCase(page)) {
                return type;
            }
        }
// Если ничего не найдено, то на главную страницу с продуктами
        return PRODUCTS;
    }

    CommandType(String pagePath, String pageName, Controller controller) {
        this.pagePath = pagePath;
        this.pageName = pageName;
        this.controller = controller;
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