package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionManager {
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;
    private static ResourceBundle resourceBundle;
    private static volatile boolean isDriverLoaded = false;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        resourceBundle = ResourceBundle.getBundle("db");
        if (resourceBundle != null) {
            URL = resourceBundle.getString("url");
            USER = resourceBundle.getString("user");
            PASSWORD = resourceBundle.getString("password");
            try {
                Class.forName(resourceBundle.getString("driver"));
                isDriverLoaded = true;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            URL = "UNDEFINED";
            USER = "UNDEFINED";
            PASSWORD = "UNDEFINED";
        }
    }

    public static Connection getConnection() {
        if (!isDriverLoaded) {
            throw new DbManagerRuntimeExeption("The driver is not loaded");
        }
        try {
            if (threadLocal.get() == null) {
                threadLocal.set(DriverManager.getConnection(URL, USER, PASSWORD));
            }
            return threadLocal.get();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DbManagerRuntimeExeption("Error getting connection " + e.getMessage());
        }
    }
}
