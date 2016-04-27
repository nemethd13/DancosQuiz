package hu.danco.quiz;

import java.util.Objects;

public class User {

    private String user;
    private int point;

    public User(String user, int point) {
        this.user = user;
        this.point = point;
    }

    public String getUser() {
        return user;
    }

    public int getPoint() {
        return point;
    }

    public void setUser(String user) {
        this.user = user;
    }

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
