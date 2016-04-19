package hu.danco.quiz;

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

}
