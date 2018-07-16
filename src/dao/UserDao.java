package dao;

import entities.User;

import java.sql.SQLException;

/**
 * Class UserDao
 * <p>
 * Created by yslabko on 08/11/2017.
 */
public interface UserDao extends DAO<User, Long> {
    User getByLogin(String login) throws SQLException;
}
