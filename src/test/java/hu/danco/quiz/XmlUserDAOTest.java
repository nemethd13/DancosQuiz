package hu.danco.quiz;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class XmlUserDAOTest {

    @Test
    public void testGetUsers() {
        XmlUserDAO instance = new XmlUserDAO("src/test/resources/UsersTest.xml");

        User u = new User("Dana", 16);

        List<User> expResult = new ArrayList<User>();

        expResult.add(u);

        List<User> result = instance.getUsers();

        assertEquals("Egy felhasználót várunk, ami megegyezik a létrehozottal", expResult, result);

    }

    @Test
    public void testPresistUsers() {
        XmlUserDAO instance = new XmlUserDAO("userTest.xml");

        User u = new User("Test", 10);

        List<User> expResult = new ArrayList<User>();

        expResult.add(u);

        instance.persistUsers(expResult);

        List<User> result = instance.getUsers();

        assertEquals("Egy felhasználót várunk, ami megegyezik a kiírt felhasználóval", expResult, result);

    }
}
