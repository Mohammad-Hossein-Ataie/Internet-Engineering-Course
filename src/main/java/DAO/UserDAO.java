package DAO;

import Entity.Movie;
import Entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {
    public static String getEnrolledID() {
        return enrolledID;
    }

    public static void setEnrolledID(String enrolledID) {
        UserDAO.enrolledID = enrolledID;
    }

    private static String enrolledID = "";
    public static void addEnrolled(String enrolled){
         setEnrolledID(enrolled);
    }
    public static Map<String, User> getUsersMails() {
        return usersMails;
    }

    private static Map<String, User> usersMails = new HashMap<>();

    public static Map<String, Integer> getWatchListUser() {
        return watchListUser;
    }

    private static Map<String, Integer> watchListUser = new HashMap<>();

    public static List<User> getUsers() {
        return users;
    }

    private static List<User> users = new ArrayList<>();



    public static List<String> getMails() {
        return mails;
    }

    private static List<String> mails = new ArrayList<>(usersMails.keySet());
    public static void addUser(User user){
        usersMails.put(user.getEmail(),user);
    }

    public static void addToWatchList(String email, int id) {
        Movie movie = MovieDAO.getMovieByID(id);
        User user = UserDAO.getUserBymail(email);
        user.setWatchList(movie);
        watchListUser.put(email,id);
    }

    public static User getUserBymail(String mail) {
        return usersMails.get(mail);
    }

    public static void removeFromWatchList(String email, int id) {
        watchListUser.remove(email,id);
    }
    public static void setUsers(List<User> newUsers) {
        users.addAll(newUsers);
        for(int i = 0; i<newUsers.size(); i++){
            String temp = newUsers.get(i).getEmail();
            usersMails.put(temp,newUsers.get(i));
        }

    }
}
