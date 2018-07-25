package dao;

import entities.Cell;
import entities.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Class UserDao
 * <p>
 * Created by yslabko on 08/11/2017.
 */
public interface UserDao extends DAO<User, Long> {
    User getByLogin(String login) throws SQLException;

    List<User> readAll() throws SQLException;

}
