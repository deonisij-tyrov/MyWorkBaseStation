package services;

import entities.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Class UserService
 * <p>
 * Created by yslabko on 08/11/2017.
 */
public interface UserService {

    User getByLogin(String login);

    User save(User user);

    List<User> readAll();

    void setStatusUser(long id, String status);
}
