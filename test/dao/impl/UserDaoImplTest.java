package dao.impl;


import dao.UserDao;
import entities.User;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import web.auth.Encoder;

import java.sql.SQLException;
import java.time.LocalDate;


public class UserDaoImplTest {
    @Rule
    UserDao userDao = UserDaoImpl.getInstance();

    @Test
    public void fullTest() throws SQLException {
        User currentUser = userDao.save(new User("name", "login",
                Encoder.encode("password"), LocalDate.now()));
        User newUser = userDao.getByLogin(currentUser.getLogin());

        userDao.delete(currentUser.getId());

        Assert.assertEquals(currentUser, newUser);
    }
}
