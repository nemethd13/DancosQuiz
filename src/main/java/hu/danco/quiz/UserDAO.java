package hu.danco.quiz;

import java.util.List;

/**
 * Created by Németh Dániel on 2016.03.23..
 */
public interface UserDAO {
    List<User> getUsers();

    void persistUsers(List<User> users);
}
