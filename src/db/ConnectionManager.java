package db;

import java.sql.Connection;

public class ConnectionManager {
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    public static Connection getConnection() throws DbManagerRuntimeExeption {
        try {
            if (tl.get() == null) {
                tl.set(DataSource.getInstance().getConnection());
            }
            return tl.get();
        } catch (Exception e) {
            throw new DbManagerRuntimeExeption("Ошибка получения соединения " + e.getMessage());
        }
    }
}
