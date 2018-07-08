import db.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestClassForeTask6 {
    private static Connection connection = ConnectionManager.getConnection();

    public static void main(String[] args) {
        try {

//            task1();
//            deleteTest();
//            task2();
//            deleteTest();
            task3();
            deleteTest();
//            task4();
////            deleteTest();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*    Сохранить в цикле через executeUpdate(), setAutoCommit(true). */
    private static void task1() throws SQLException {
        long start = System.currentTimeMillis();
        connection.setAutoCommit(true);
        connection.setTransactionIsolation(4);
        for (int i = 0; i < 1000; i++) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO cell (id, cell_name, sector, power_id, bs_id, band_id) VALUES (DEFAULT, 'test', 0, 0, 0, 0);");
        }
        System.out.println("время выполнения для варианта 'setAutoCommit(true)'=" + (System.currentTimeMillis() - start));
    }

    /*    Сохранить в цикле через addBatch() и executeBatch() каждые 5000 записей, setAutoCommit(true). */
    private static void task2() throws SQLException {
        long start = System.currentTimeMillis();
        connection.setAutoCommit(true);
        Statement statement = connection.createStatement();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 500; j++) {
                statement.addBatch("INSERT INTO cell (id, cell_name, sector, power_id, bs_id, band_id) VALUES (DEFAULT, 'test', 0, 0, 0, 0);");
            }
            statement.executeBatch();
        }
        System.out.println("время выполнения для варианта 'addBatch() - executeBatch() - setAutoCommit(true)'=" + (System.currentTimeMillis() - start));
    }

    /*    Сохранить в цикле через executeUpdate(), setAutoCommit(false) и commit() на 100000 записи. */
    private static void task3() throws SQLException {
        long start = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 0; i < 10000; i++) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO cell (id, cell_name, sector, power_id, bs_id, band_id) VALUES (DEFAULT, 'test', 0, 0, 0, 0);");
        }
        connection.commit();
        System.out.println("время выполнения для варианта 'setAutoCommit(false)'=" + (System.currentTimeMillis() - start));
    }

    /*    Сохранить в цикле через addBatch() и executeBatch() каждые 5000 записей, setAutoCommit(false) и commit() на 100000 записи. */
    private static void task4() throws SQLException {
        long start = System.currentTimeMillis();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 500; j++) {
                statement.addBatch("INSERT INTO cell (id, cell_name, sector, power_id, bs_id, band_id) VALUES (DEFAULT, 'test', 0, 0, 0, 0);");
            }
            statement.executeBatch();
        }
        connection.commit();
        System.out.println("время выполнения для варианта 'addBatch() - executeBatch()- setAutoCommit(false)'=" + (System.currentTimeMillis() - start));
    }

    private static void deleteTest() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM cell WHERE cell_name = 'test';");
    }

}
