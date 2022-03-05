package Entity;

import DAO.MovieDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User{
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public static List<Movie> getWatchList() {
        return watchList;
    }
    private static List<Movie> watchList = new ArrayList<>();
    private String email;
    private String password;
    private String nickname;
    private String name;
    private Date birthDate;
    public boolean isSame(String email) {
        return this.email.equals(email);
    }
}
