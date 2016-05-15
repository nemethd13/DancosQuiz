package hu.danco.quiz;

import java.util.Objects;

/**
 * Egy felhasználót reprezentáló osztály.
 */

public class User {

    private String user;
    private int point;

    /**
     * Konstruktor egy User objektum létrehozására.
     * 
     * @param user
     * @param point 
     */
    
    public User(String user, int point) {
        this.user = user;
        this.point = point;
    }

    /**
     * Visszaadja a felhasználó nevét.
     * 
     * @return a felhasználó neve 
     */
    
    public String getUser() {
        return user;
    }

    /**
     * Visszadja a felhasználó által helyesen
     * megválaszolt kérdések számát.
     * 
     * @return helyes válaszok darabszáma
     */
    
    public int getPoint() {
        return point;
    }

    /**
     * Beállítja a felhasználó nevét.
     * 
     * @param user felhasználó neve 
     */
    
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Beállítja a felhasználó helyes válaszainak számát.
     * 
     * @param point helyes válaszok száma 
     */
    
    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "User{" + "user=" + user + ", point=" + point + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.user);
        hash = 37 * hash + this.point;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (this.point != other.point) {
            return false;
        }
        return true;
    }
    

}
