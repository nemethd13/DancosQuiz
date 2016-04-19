package hu.danco.quiz;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();

    void persistUsers(List<User> users);
}
