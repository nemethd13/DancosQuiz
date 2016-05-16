package hu.danco.quiz;

import java.util.List;

/** 
 * A felhasználókról adatokat tartalmazó adatbázist
 * feldolgozó interfész. 
 */

public interface UserDAO {
    
    /**
     * {@inheritDoc}
     * 
     * Visszadja az adatbázisban szereplő felhasználók
     * nevét illetve a helyesen megválaszolt kérdések 
     * számát egy listába.
     * 
     * @return egy {@code User} objektumokat tartalmaazó lista
     */
    
    List<User> getUsers();
    
    /**
     * {@inheritDoc}
     * 
     * Kiírja az adatbázisba a paraméterül kapott
     * listában szereplő felhasználókat és eredményeiket.
     * 
     * @param users {@code User} objektumokat tartalmazó lista 
     */

    void persistUsers(List<User> users);
}
