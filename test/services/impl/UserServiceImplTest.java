package services.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entities.User;
import org.junit.*;
import services.UserService;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    public UserService userService = UserServiceImpl.getInstance();
    public UserDao userDao = UserDaoImpl.getInstance();
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("test", "test", "test", LocalDate.now());
    }

    @Test
    public void setStatusUser() throws Exception {
        user = userDao.save(user);
        user.setStatus("INACTIVE");
        userService.setStatusUser(user.getId(), user.getStatus());
        Assert.assertEquals(user.getStatus(), userDao.get(user.getId()).getStatus());
    }

    @After
    public void tearDown() throws Exception {
        userDao.delete(user.getId());
    }
}