package dao.impl;


import dao.UserDao;
import entities.User;

import java.sql.*;

/**
 * Class UserDaoImpl
 * <p>
 * Created by yslabko on 08/11/2017.
 */
public class UserDaoImpl extends AbstractDao implements UserDao {
    private static final String getUser = "SELECT * FROM USER WHERE LOGIN=?";
    private static final String saveUser = "INSERT INTO USER (LOGIN, PASSWORD, NAME, BIRTHDAY, STATUS) VALUES (?, ?, ?, ? ,'ACTIVE');";
    private static volatile UserDao INSTANCE = null;
    private PreparedStatement psGetByLogin;

    public static UserDao getInstance() {
        UserDao userDao = INSTANCE;
        if (userDao == null) {
            synchronized (UserDaoImpl.class) {
                userDao = INSTANCE;
                if (userDao == null) {
                    INSTANCE = userDao = new UserDaoImpl();
                }
            }
        }

        return userDao;
    }

    @Override
    public User getByLogin(String login) throws SQLException {
        psGetByLogin = prepareStatement(getUser);
        psGetByLogin.setString(1, login);
        ResultSet resultSet = psGetByLogin.executeQuery();
        if (resultSet.next()) {
            return populateEntity(resultSet);
        }
        close(resultSet);

        return null;
    }

    @Override
    public User save(User user) throws SQLException {
        PreparedStatement psCreate = prepareStatement(saveUser, Statement.RETURN_GENERATED_KEYS);
        psCreate.setString(1, user.getLogin());
        psCreate.setString(2, user.getPassword());
        psCreate.setString(3, user.getName());
        psCreate.setDate(4, Date.valueOf(user.getDate()));
        psCreate.executeUpdate();
        ResultSet resultSet = psCreate.getGeneratedKeys();
        close(resultSet);
        return user;
    }

    @Override
    public User get(Long id) throws SQLException {
        return null;
    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public int delete(Long id) throws SQLException {
        return 0;
    }

    private User populateEntity(ResultSet rs) throws SQLException {
        User entity = new User();
        entity.setId(rs.getLong(1));
        entity.setName(rs.getString(2));
        entity.setLogin(rs.getString(3));
        entity.setPassword(rs.getString(4));
        entity.setStatus(rs.getString(6));
        entity.setRole(rs.getString(7));
        return entity;
    }
}