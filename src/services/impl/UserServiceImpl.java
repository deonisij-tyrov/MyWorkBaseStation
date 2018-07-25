package services.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entities.User;
import services.ServiceRuntimeExeption;
import services.UserService;

import java.sql.SQLException;
import java.util.List;

/**
 * Class UserServiceImpl
 * <p>
 * Created by yslabko on 08/11/2017.
 */
public class UserServiceImpl extends AbstractService implements UserService {
    private static volatile UserService INSTANCE = null;
    private UserDao userDao = UserDaoImpl.getInstance();

    public static UserService getInstance() {
        UserService userService = INSTANCE;
        if (userService == null) {
            synchronized (UserServiceImpl.class) {
                userService = INSTANCE;
                if (userService == null) {
                    INSTANCE = userService = new UserServiceImpl();
                }
            }
        }

        return userService;
    }

    @Override
    public User getByLogin(String login) {
        try {
            return userDao.getByLogin(login);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error getting User by login " + login);
        }
    }

    @Override
    public User save(User user) {
        try {
            return userDao.save(user);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error save User by login " + user);
        }
    }

    @Override
    public List<User> readAll() {
        try {
            return userDao.readAll();
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error get all users");
        }
    }

    @Override
    public void setStatusUser(long id, String status) {
        try {
            User user = userDao.get(id);
            user.setStatus(status);
            userDao.update(user);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error update users status " + id);
        }
    }
}
