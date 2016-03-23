package hu.danco.quiz;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Németh Dániel on 2016.03.23..
 */
public class MainApp {
    public static void main(String[] args) {
        UserDAO u = new XmlUserDAO();

        List<User> lst = new ArrayList<User>();

        lst.add(new User("Dancoka", "100"));

        u.persistUsers(lst);
    }
}
